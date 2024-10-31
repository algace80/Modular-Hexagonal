package org.alejandro.hexagonal.offer.model.entity;

import org.alejandro.hexagonal.offer.model.exception.OfferArgumentNotValidException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {

    @Test
    void testValidCurrencyCreation() {
        // Arrange
        String validCurrencyIso = "EUR"; // A valid currency from OfferConstant.CURRENCIES

        // Act
        Currency currency = new Currency(validCurrencyIso);

        // Assert
        assertEquals(validCurrencyIso, currency.getValueCurrencyIso());
    }

    @Test
    void testInvalidCurrencyCreation() {
        // Arrange
        String invalidCurrencyIso = "INVALID";

        // Act & Assert
        OfferArgumentNotValidException exception = assertThrows(OfferArgumentNotValidException.class, () -> {
            new Currency(invalidCurrencyIso);
        });

        assertEquals(ErrorCatalog.INVALID_CUERRENCY_OFFER.getCode(), exception.getErrorCode());
        assertEquals(String.format(ErrorCatalog.INVALID_CUERRENCY_OFFER.getMessage(), Currency.class.getSimpleName()), exception.getErrorMessage());
    }

    @Test
    void testNullCurrencyCreation() {
        // Arrange
        String nullCurrencyIso = null;

        // Act
        Currency currency = new Currency(nullCurrencyIso);

        // Assert
        assertNull(currency.getValueCurrencyIso());
    }
}
