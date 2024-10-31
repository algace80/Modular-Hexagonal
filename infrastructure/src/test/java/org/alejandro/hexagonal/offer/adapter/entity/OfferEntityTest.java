package org.alejandro.hexagonal.offer.adapter.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class OfferEntityTest {

    @Test
    void testOfferEntityCreation() {
        // Arrange
        Integer brandId = 1;
        Timestamp startDate = new Timestamp(System.currentTimeMillis());
        Timestamp endDate = new Timestamp(System.currentTimeMillis() + 86400000); // 1 día después
        Integer priceListId = 101;
        String size = "01";
        String model = "2543";
        String quality = "443";
        Integer priority = 1;
        BigDecimal price = BigDecimal.valueOf(99.99);
        String currencyIso = "USD";

        // Act
        OfferEntity offerEntity = new OfferEntity(brandId, startDate, endDate, priceListId,
                size, model, quality, priority, price, currencyIso);

        // Assert
        assertNotNull(offerEntity);
        assertEquals(brandId, offerEntity.getBrandId());
        assertEquals(startDate, offerEntity.getStartDate());
        assertEquals(endDate, offerEntity.getEndDate());
        assertEquals(priceListId, offerEntity.getPriceListId());
        assertEquals(size, offerEntity.getSize());
        assertEquals(model, offerEntity.getModel());
        assertEquals(quality, offerEntity.getQuality());
        assertEquals(priority, offerEntity.getPriority());
        assertEquals(price, offerEntity.getPrice());
        assertEquals(currencyIso, offerEntity.getCurrencyIso());
    }

    @Test
    void testOfferEntityDefaultConstructor() {
        // Act
        OfferEntity offerEntity = new OfferEntity();

        // Assert
        assertNotNull(offerEntity);
        assertNull(offerEntity.getId());
        assertNull(offerEntity.getBrandId());
        assertNull(offerEntity.getStartDate());
        assertNull(offerEntity.getEndDate());
        assertNull(offerEntity.getPriceListId());
        assertNull(offerEntity.getSize());
        assertNull(offerEntity.getModel());
        assertNull(offerEntity.getQuality());
        assertNull(offerEntity.getPriority());
        assertNull(offerEntity.getPrice());
        assertNull(offerEntity.getCurrencyIso());
    }
}
