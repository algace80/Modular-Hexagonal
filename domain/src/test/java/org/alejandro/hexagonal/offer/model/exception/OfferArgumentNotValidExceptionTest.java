package org.alejandro.hexagonal.offer.model.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OfferArgumentNotValidExceptionTest {

    @Test
    void testExceptionCreation() {
        // Arrange
        String expectedErrorCode = "ERR_CODE";
        String expectedErrorMessage = "Invalid argument";

        // Act
        OfferArgumentNotValidException exception = new OfferArgumentNotValidException(expectedErrorCode, expectedErrorMessage);

        // Assert
        assertEquals(expectedErrorCode, exception.getErrorCode());
        assertEquals(expectedErrorMessage, exception.getErrorMessage());
    }
}
