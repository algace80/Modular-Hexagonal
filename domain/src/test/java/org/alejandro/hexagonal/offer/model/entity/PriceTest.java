package org.alejandro.hexagonal.offer.model.entity;

import org.alejandro.hexagonal.offer.model.exception.OfferArgumentNotValidException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {

    @Test
    void testValidPrice() {
        // Arrange
        BigDecimal validPrice = new BigDecimal("10.00");

        // Act
        Price price = new Price(validPrice);

        // Assert
        assertEquals(validPrice, price.getValuePrice());
    }

    @Test
    void testPriceWithNegativeValue() {
        // Act & Assert
        OfferArgumentNotValidException exception = assertThrows(OfferArgumentNotValidException.class, () -> {
            new Price(new BigDecimal("-1.00"));
        });

        assertEquals(ErrorCatalog.INVALID_SIZE_OFFER.getCode(), exception.getErrorCode());
        assertEquals("Invalid offer parameter. The size of Price should be greater than 0", exception.getErrorMessage());
    }

    @Test
    void testPriceWithNullValue() {
        // Arrange & Act
        Price price = new Price(null);

        // Assert
        assertNull(price.getValuePrice());
    }
}
