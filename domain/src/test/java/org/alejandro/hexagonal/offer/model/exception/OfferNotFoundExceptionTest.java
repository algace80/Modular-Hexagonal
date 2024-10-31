package org.alejandro.hexagonal.offer.model.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OfferNotFoundExceptionTest {

    @Test
    void testExceptionCreation() {
        // Arrange
        String expectedErrorCode = "ERR_NOT_FOUND";
        String expectedErrorMessage = "Offer not found";

        // Act
        OfferNotFoundException exception = new OfferNotFoundException(expectedErrorCode, expectedErrorMessage);

        // Assert
        assertEquals(expectedErrorCode, exception.getErrorCode());
        assertEquals(expectedErrorMessage, exception.getErrorMessage());
    }
}
