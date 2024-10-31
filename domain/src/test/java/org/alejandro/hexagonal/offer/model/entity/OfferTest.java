package org.alejandro.hexagonal.offer.model.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class OfferTest {

    @Test
    void testOfferCreation() {
        // Arrange
        Long offerId = 1L;
        Integer brandId = 100;
        Timestamp startDate = Timestamp.valueOf("2023-10-01 10:00:00");
        Timestamp endDate = Timestamp.valueOf("2023-10-31 10:00:00");
        Integer priceListId = 200;
        String productPartNumber = "125436978";
        Integer priority = 1;
        BigDecimal price = BigDecimal.valueOf(99.99);
        String currencyIso = "EUR";

        // Act
        Offer offer = new Offer(offerId, brandId, startDate, endDate, priceListId, productPartNumber, priority, price, currencyIso);

        // Assert
        assertEquals(offerId, offer.getOfferId().getId());
        assertEquals(brandId, offer.getBrandId().getId());
        assertEquals(startDate, offer.getStartDate().returnStartDateForEntity());
        assertEquals(endDate, offer.getEndDate().returnEndDateForEntity());
        assertEquals(priceListId, offer.getPriceListId().getValueListId());
        assertEquals(productPartNumber, offer.getProductPartNumber().getValueProductPartNumber());
        assertEquals(priority, offer.getPriority().getValuePriority());
        assertEquals(price, offer.getPrice().getValuePrice());
        assertEquals(currencyIso, offer.getCurrencyIso().getValueCurrencyIso());
    }

    @Test
    void testToCreate() {
        // Arrange
        Offer offer = new Offer();
        Integer brandId = 100;
        String startDate = "01/10/2023 10:00";
        String endDate = "31/10/2023 10:00";
        Integer priceListId = 200;
        String productPartNumber = "125436978";
        Integer priority = 1;
        BigDecimal price = BigDecimal.valueOf(99.99);
        String currencyIso = "EUR";

        // Act
        Offer updatedOffer = offer.toCreate(brandId, startDate, endDate, priceListId, productPartNumber, priority, price, currencyIso);

        // Assert
        assertEquals(brandId, updatedOffer.getBrandId().getId());
        assertEquals(startDate, updatedOffer.getStartDate().returnStartDateForDto());
        assertEquals(endDate, updatedOffer.getEndDate().returnEndDateForDto());
        assertEquals(priceListId, updatedOffer.getPriceListId().getValueListId());
        assertEquals(productPartNumber, updatedOffer.getProductPartNumber().getValueProductPartNumber());
        assertEquals(priority, updatedOffer.getPriority().getValuePriority());
        assertEquals(price, updatedOffer.getPrice().getValuePrice());
        assertEquals(currencyIso, updatedOffer.getCurrencyIso().getValueCurrencyIso());
    }

    @Test
    void testToUpdate() {
        // Arrange
        Long offerId = 1L;
        Offer offer = new Offer();
        Integer brandId = 100;
        String startDate = "01/10/2023 10:00";
        String endDate = "31/10/2023 10:00";
        Integer priceListId = 200;
        String productPartNumber = "125436978";
        Integer priority = 1;
        BigDecimal price = BigDecimal.valueOf(99.99);
        String currencyIso = "EUR";

        // Act
        Offer updatedOffer = offer.toUpdate(offerId, brandId, startDate, endDate, priceListId, productPartNumber, priority, price, currencyIso);

        // Assert
        assertEquals(offerId, updatedOffer.getOfferId().getId());
        assertEquals(brandId, updatedOffer.getBrandId().getId());
        assertEquals(startDate, updatedOffer.getStartDate().returnStartDateForDto());
        assertEquals(endDate, updatedOffer.getEndDate().returnEndDateForDto());
        assertEquals(priceListId, updatedOffer.getPriceListId().getValueListId());
        assertEquals(productPartNumber, updatedOffer.getProductPartNumber().getValueProductPartNumber());
        assertEquals(priority, updatedOffer.getPriority().getValuePriority());
        assertEquals(price, updatedOffer.getPrice().getValuePrice());
        assertEquals(currencyIso, updatedOffer.getCurrencyIso().getValueCurrencyIso());
    }
}
