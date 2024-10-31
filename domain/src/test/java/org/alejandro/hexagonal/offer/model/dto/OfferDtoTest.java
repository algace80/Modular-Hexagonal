package org.alejandro.hexagonal.offer.model.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OfferDtoTest {

    @Test
    void testOfferDtoGettersAndSetters() {
        // Arrange
        OfferDto offerDto = new OfferDto();
        Long expectedOfferId = 1L;
        Integer expectedBrandId = 1;
        String expectedStartDate = "01/01/2023 10:00";
        String expectedEndDate = "31/12/2023 10:00";
        Integer expectedPriceListId = 100;
        String expectedProductPartNumber = "123456789";
        Integer expectedPriority = 1;
        BigDecimal expectedPrice = BigDecimal.valueOf(99.99);
        String expectedCurrencyIso = "EUR";

        // Act
        offerDto.setOfferId(expectedOfferId);
        offerDto.setBrandId(expectedBrandId);
        offerDto.setStartDate(expectedStartDate);
        offerDto.setEndDate(expectedEndDate);
        offerDto.setPriceListId(expectedPriceListId);
        offerDto.setProductPartNumber(expectedProductPartNumber);
        offerDto.setPriority(expectedPriority);
        offerDto.setPrice(expectedPrice);
        offerDto.setCurrencyIso(expectedCurrencyIso);

        // Assert
        assertEquals(expectedOfferId, offerDto.getOfferId());
        assertEquals(expectedBrandId, offerDto.getBrandId());
        assertEquals(expectedStartDate, offerDto.getStartDate());
        assertEquals(expectedEndDate, offerDto.getEndDate());
        assertEquals(expectedPriceListId, offerDto.getPriceListId());
        assertEquals(expectedProductPartNumber, offerDto.getProductPartNumber());
        assertEquals(expectedPriority, offerDto.getPriority());
        assertEquals(expectedPrice, offerDto.getPrice());
        assertEquals(expectedCurrencyIso, offerDto.getCurrencyIso());
    }

    @Test
    void testOfferDtoAllArgsConstructor() {
        // Arrange
        OfferDto offerDto = new OfferDto(1L, 1, "01/01/2023 10:00", "31/12/2023 10:00", 100, "123456789", 1, BigDecimal.valueOf(99.99), "EUR");

        // Assert
        assertEquals(1L, offerDto.getOfferId());
        assertEquals(1, offerDto.getBrandId());
        assertEquals("01/01/2023 10:00", offerDto.getStartDate());
        assertEquals("31/12/2023 10:00", offerDto.getEndDate());
        assertEquals(100, offerDto.getPriceListId());
        assertEquals("123456789", offerDto.getProductPartNumber());
        assertEquals(1, offerDto.getPriority());
        assertEquals(BigDecimal.valueOf(99.99), offerDto.getPrice());
        assertEquals("EUR", offerDto.getCurrencyIso());
    }
}
