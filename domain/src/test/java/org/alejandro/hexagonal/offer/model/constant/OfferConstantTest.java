package org.alejandro.hexagonal.offer.model.constant;

import org.alejandro.hexagonal.offer.model.constant.OfferConstant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OfferConstantTest {

    @Test
    void testDateTimeFormatter() {
        // Assert
        assertEquals("dd/MM/yyyy HH:mm", OfferConstant.DATE_TIME_FORMATTER);
    }

    @Test
    void testCurrencies() {
        // Assert
        String[] expectedCurrencies = {"EUR", "USD"};
        assertArrayEquals(expectedCurrencies, OfferConstant.CURRENCIES);
    }
}
