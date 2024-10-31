package org.alejandro.hexagonal.offer.model.exception.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorCatalogTest {

    @Test
    void testErrorCatalogValues() {
        // Arrange
        ErrorCatalog[] errorCatalogs = ErrorCatalog.values();

        // Act & Assert
        assertEquals("ERR_OFFER_01", errorCatalogs[0].getCode());
        assertEquals("Offer not found", errorCatalogs[0].getMessage());

        assertEquals("ERR_OFFER_02_01", errorCatalogs[1].getCode());
        assertEquals("Invalid offer parameter. %s can't be null", errorCatalogs[1].getMessage());

        assertEquals("ERR_OFFER_02_02", errorCatalogs[2].getCode());
        assertEquals("Invalid offer parameter. The length of %s should be %s", errorCatalogs[2].getMessage());

        assertEquals("ERR_OFFER_02_03", errorCatalogs[3].getCode());
        assertEquals("Invalid offer parameter. The size of %s should be greater than %s", errorCatalogs[3].getMessage());

        assertEquals("ERR_OFFER_02_04", errorCatalogs[4].getCode());
        assertEquals("Invalid offer parameter. The %s format should be dd/MM/yyyy HH:mm", errorCatalogs[4].getMessage());

        assertEquals("ERR_OFFER_02_05", errorCatalogs[5].getCode());
        assertEquals("Invalid offer parameter. The %s format should be EUR or USD", errorCatalogs[5].getMessage());

        assertEquals("ERR_GEN_01", errorCatalogs[6].getCode());
        assertEquals("An unexpected error occurred", errorCatalogs[6].getMessage());
    }
}
