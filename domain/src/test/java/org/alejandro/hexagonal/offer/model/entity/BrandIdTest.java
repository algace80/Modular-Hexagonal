package org.alejandro.hexagonal.offer.model.entity;

import org.alejandro.hexagonal.offer.model.exception.OfferArgumentNotValidException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandIdTest {

    @Test
    void testValidBrandIdCreation() {
        // Arrange
        Integer validBrandId = 1;

        // Act
        BrandId brandId = new BrandId(validBrandId);

        // Assert
        assertEquals(validBrandId, brandId.getId());
    }

    @Test
    void testNullBrandIdCreation() {
        // Arrange
        Integer nullBrandId = null;

        // Act & Assert
        OfferArgumentNotValidException exception = assertThrows(OfferArgumentNotValidException.class, () -> {
            new BrandId(nullBrandId);
        });

        assertEquals(ErrorCatalog.INVALID_NULL_PARAMETER_OFFER.getCode(), exception.getErrorCode());
        assertEquals(String.format(ErrorCatalog.INVALID_NULL_PARAMETER_OFFER.getMessage(), BrandId.class.getSimpleName()), exception.getErrorMessage());
    }
}
