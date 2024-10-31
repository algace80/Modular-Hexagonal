package org.alejandro.hexagonal.offer.model.entity;

import org.alejandro.hexagonal.offer.model.exception.OfferArgumentNotValidException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceListIdTest {

    @Test
    void testValidPriceListId() {
        // Arrange
        Integer validPriceListId = 1;

        // Act
        PriceListId priceListId = new PriceListId(validPriceListId);

        // Assert
        assertEquals(validPriceListId, priceListId.getValueListId());
    }

    @Test
    void testPriceListIdWithNull() {
        // Act & Assert
        OfferArgumentNotValidException exception = assertThrows(OfferArgumentNotValidException.class, () -> {
            new PriceListId(null);
        });

        assertEquals(ErrorCatalog.INVALID_NULL_PARAMETER_OFFER.getCode(), exception.getErrorCode());
        assertEquals("Invalid offer parameter. PriceListId can't be null", exception.getErrorMessage());
    }
}
