package org.alejandro.hexagonal.offer.adapter.mapper;

import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.adapter.entity.OfferEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class OfferDboMapperTest {

    private final OfferDboMapper offerDboMapper = new OfferDboMapper();

    @Test
    void toDboCreate_ShouldReturnOfferEntity_WhenDomainIsValid() {
        // Arrange
        Offer offer = new Offer(
                1L,  // offerId
                1,    // brandId
                Timestamp.valueOf("2024-01-01 00:00:00"), // startDate
                Timestamp.valueOf("2024-12-31 23:59:59"), // endDate
                1,    // priceListId
                "01",  // size
                "2543", // model
                "443",  // quality
                1,    // priority
                BigDecimal.valueOf(35.5), // price
                "USD" // currencyIso
        );

        // Act
        OfferEntity offerEntity = offerDboMapper.toDboCreate(offer);

        // Assert
        assertNotNull(offerEntity);
        assertEquals(1, offerEntity.getBrandId());
        assertEquals(Timestamp.valueOf("2024-01-01 00:00:00"), offerEntity.getStartDate());
        assertEquals(Timestamp.valueOf("2024-12-31 23:59:59"), offerEntity.getEndDate());
        assertEquals(1, offerEntity.getPriceListId());
        assertEquals("01", offerEntity.getSize());
        assertEquals("2543", offerEntity.getModel());
        assertEquals("443", offerEntity.getQuality());
        assertEquals(1, offerEntity.getPriority());
        assertEquals(BigDecimal.valueOf(35.5), offerEntity.getPrice());
        assertEquals("USD", offerEntity.getCurrencyIso());
    }

    @Test
    void toDboCreate_ShouldReturnNull_WhenDomainIsNull() {
        // Act
        OfferEntity offerEntity = offerDboMapper.toDboCreate(null);

        // Assert
        assertNull(offerEntity);
    }

    @Test
    void toDboUpdate_ShouldReturnOfferEntity_WhenDomainIsValid() {
        // Arrange
        Offer offer = new Offer(1L,1,
                Timestamp.valueOf("2024-01-01 00:00:00"), Timestamp.valueOf("2024-12-31 23:59:59"), 1, "01",
                "2543", "443", 1, BigDecimal.valueOf(35.5), "USD"
        );

        // Act
        OfferEntity offerEntity = offerDboMapper.toDboUpdate(offer);

        // Assert
        assertNotNull(offerEntity);
        assertEquals(1L, offerEntity.getId());
        assertEquals(1, offerEntity.getBrandId());
        assertEquals(Timestamp.valueOf("2024-01-01 00:00:00"), offerEntity.getStartDate());
        assertEquals(Timestamp.valueOf("2024-12-31 23:59:59"), offerEntity.getEndDate());
        assertEquals(1, offerEntity.getPriceListId());
        assertEquals("01", offerEntity.getSize());
        assertEquals("2543", offerEntity.getModel());
        assertEquals("443", offerEntity.getQuality());
        assertEquals(1, offerEntity.getPriority());
        assertEquals(BigDecimal.valueOf(35.5), offerEntity.getPrice());
        assertEquals("USD", offerEntity.getCurrencyIso());
    }

    @Test
    void toDboUpdate_ShouldReturnNull_WhenDomainIsNull() {
        // Act
        OfferEntity offerEntity = offerDboMapper.toDboUpdate(null);

        // Assert
        assertNull(offerEntity);
    }

    @Test
    void toDomain_ShouldReturnOffer_WhenEntityIsValid() {
        // Arrange
        OfferEntity offerEntity = new OfferEntity(1L,  1,
                Timestamp.valueOf("2024-01-01 00:00:00"), Timestamp.valueOf("2024-12-31 23:59:59"),
                1, "01", "2543", "443", 1, BigDecimal.valueOf(35.5), "USD"
        );

        // Act
        Offer offer = offerDboMapper.toDomain(offerEntity);

        // Assert
        assertNotNull(offer);
        assertEquals(1L, offer.getOfferId().getId());
        assertEquals(1, offer.getBrandId().getId());
        assertEquals(Timestamp.valueOf("2024-01-01 00:00:00"), offer.getStartDate().returnStartDateForEntity());
        assertEquals(Timestamp.valueOf("2024-12-31 23:59:59"), offer.getEndDate().returnEndDateForEntity());
        assertEquals(1, offer.getPriceListId().getValueListId());
        assertEquals("01", offer.getProductPartNumber().getSize().getValueSize());
        assertEquals("2543", offer.getProductPartNumber().getModel().getValueModel());
        assertEquals("443", offer.getProductPartNumber().getQuality().getValueQuality());
        assertEquals(1, offer.getPriority().getValuePriority());
        assertEquals(BigDecimal.valueOf(35.5), offer.getPrice().getValuePrice());
        assertEquals("USD", offer.getCurrencyIso().getValueCurrencyIso());
    }

    @Test
    void toDomain_ShouldReturnNull_WhenEntityIsNull() {
        // Act
        Offer offer = offerDboMapper.toDomain(null);

        // Assert
        assertNull(offer);
    }
}
