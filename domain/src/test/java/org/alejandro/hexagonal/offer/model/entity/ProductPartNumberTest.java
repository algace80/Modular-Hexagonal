package org.alejandro.hexagonal.offer.model.entity;

import org.alejandro.hexagonal.offer.model.exception.OfferArgumentNotValidException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductPartNumberTest {

    @Test
    void testValidProductPartNumber() {
        // Arrange
        String validPartNumber = "012543443";

        // Act
        ProductPartNumber productPartNumber = new ProductPartNumber(validPartNumber);

        // Assert
        assertEquals("01", productPartNumber.getSize().getValueSize());
        assertEquals("2543", productPartNumber.getModel().getValueModel());
        assertEquals("443", productPartNumber.getQuality().getValueQuality());
        assertEquals("012543443", productPartNumber.getValueProductPartNumber());
    }

    @Test
    void testProductPartNumberWithNull() {
        // Act & Assert
        OfferArgumentNotValidException exception = assertThrows(OfferArgumentNotValidException.class, () -> {
            new ProductPartNumber((String) null);
        });

        assertEquals(ErrorCatalog.INVALID_NULL_PARAMETER_OFFER.getCode(), exception.getErrorCode());
        assertEquals("Invalid offer parameter. ProductPartNumber can't be null", exception.getErrorMessage());
    }

    @Test
    void testProductPartNumberWithInvalidLength() {
        // Act & Assert
        OfferArgumentNotValidException exception = assertThrows(OfferArgumentNotValidException.class, () -> {
            new ProductPartNumber("123");
        });

        assertEquals(ErrorCatalog.INVALID_LENGTH_OFFER.getCode(), exception.getErrorCode());
        assertEquals("Invalid offer parameter. The length of ProductPartNumber should be 9", exception.getErrorMessage());
    }

    @Test
    void testProductPartNumberWithValidComponents() {
        // Arrange
        String size = "01";
        String model = "2543";
        String quality = "443";

        // Act
        ProductPartNumber productPartNumber = new ProductPartNumber(size, model, quality);

        // Assert
        assertEquals(size, productPartNumber.getSize().getValueSize());
        assertEquals(model, productPartNumber.getModel().getValueModel());
        assertEquals(quality, productPartNumber.getQuality().getValueQuality());
        assertEquals("012543443", productPartNumber.getValueProductPartNumber());
    }

    @Test
    void testProductPartNumberSizeHandling() {
        // Arrange
        String partNumber = "012534543";

        // Act
        ProductPartNumber productPartNumber = new ProductPartNumber(partNumber);

        // Assert
        assertEquals("01", productPartNumber.getSize().getValueSize());
    }

    @Test
    void testProductPartNumberModelHandling() {
        // Arrange
        String partNumber = "012534543";

        // Act
        ProductPartNumber productPartNumber = new ProductPartNumber(partNumber);

        // Assert
        assertEquals("2534", productPartNumber.getModel().getValueModel());
    }

    @Test
    void testProductPartNumberQualityHandling() {
        // Arrange
        String partNumber = "012534543";

        // Act
        ProductPartNumber productPartNumber = new ProductPartNumber(partNumber);

        // Assert
        assertEquals("543", productPartNumber.getQuality().getValueQuality());
    }
}
