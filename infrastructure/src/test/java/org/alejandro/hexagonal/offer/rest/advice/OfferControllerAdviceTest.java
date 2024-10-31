package org.alejandro.hexagonal.offer.rest.advice;

import org.alejandro.hexagonal.offer.model.exception.OfferArgumentNotValidException;
import org.alejandro.hexagonal.offer.model.exception.OfferNotFoundException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OfferControllerAdviceTest {

    private final OfferControllerAdvice offerControllerAdvice = new OfferControllerAdvice();

    @Test
    void handleOfferNotFoundException_ReturnsCorrectResponse() {
        // Arrange
        String expectedMessage = ErrorCatalog.OFFER_NOT_FOUND.getMessage();
        String expectedCode = ErrorCatalog.OFFER_NOT_FOUND.getCode(); // o el código de error que uses

        OfferNotFoundException exception = new OfferNotFoundException(expectedCode, expectedMessage);

        // Act
        offerControllerAdvice.handleOfferNotFoundException(exception);

        // Assert
        assertEquals(expectedCode , exception.getErrorCode());
        assertEquals( expectedMessage, exception.getErrorMessage());
    }

    @Test
    void handleOfferArgumentNotValidException_ReturnsCorrectResponse() {
        // Arrange
        String expectedMessage = "Invalid argument";
        String expectedCode = "400";

        OfferArgumentNotValidException exception = new OfferArgumentNotValidException(expectedCode, expectedMessage);

        // Act
        ErrorResponse response = offerControllerAdvice.handleOfferArgumentNotValidException(exception);

        // Assert
        assertEquals(expectedMessage, response.getMessage());
        assertEquals(expectedCode, response.getCode());

    }

    @Test
    void handleGenericError_ReturnsGenericResponse() {
        // Arrange
        String genericMessage = "An unexpected error occurred";
        Exception exception = new Exception(genericMessage);

        // Act
        ErrorResponse response = offerControllerAdvice.handleGenericError(exception);

        // Assert
        assertEquals(ErrorCatalog.GENERIC_ERROR.getCode(), response.getCode());
        assertEquals(ErrorCatalog.GENERIC_ERROR.getMessage(), response.getMessage());
        assertEquals(1, response.getDetails().size());
        assertEquals(genericMessage, response.getDetails().get(0));
    }
}
