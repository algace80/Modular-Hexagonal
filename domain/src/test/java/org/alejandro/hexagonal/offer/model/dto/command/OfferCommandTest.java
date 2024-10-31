package org.alejandro.hexagonal.offer.model.dto.command;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OfferCommandTest {

    @Test
    void testOfferCommandGettersAndSetters() {
        // Arrange
        OfferCommand offerCommand = new OfferCommand();
        Integer expectedBrandId = 1;
        String expectedStartDate = "01/01/2023 10:00";
        String expectedEndDate = "31/12/2023 10:00";
        Integer expectedPriceListId = 100;
        String expectedProductPartNumber = "123456789";
        Integer expectedPriority = 1;
        BigDecimal expectedPrice = BigDecimal.valueOf(99.99);
        String expectedCurrencyIso = "EUR";

        // Act
        offerCommand.setBrandId(expectedBrandId);
        offerCommand.setStartDate(expectedStartDate);
        offerCommand.setEndDate(expectedEndDate);
        offerCommand.setPriceListId(expectedPriceListId);
        offerCommand.setProductPartNumber(expectedProductPartNumber);
        offerCommand.setPriority(expectedPriority);
        offerCommand.setPrice(expectedPrice);
        offerCommand.setCurrencyIso(expectedCurrencyIso);

        // Assert
        assertEquals(expectedBrandId, offerCommand.getBrandId());
        assertEquals(expectedStartDate, offerCommand.getStartDate());
        assertEquals(expectedEndDate, offerCommand.getEndDate());
        assertEquals(expectedPriceListId, offerCommand.getPriceListId());
        assertEquals(expectedProductPartNumber, offerCommand.getProductPartNumber());
        assertEquals(expectedPriority, offerCommand.getPriority());
        assertEquals(expectedPrice, offerCommand.getPrice());
        assertEquals(expectedCurrencyIso, offerCommand.getCurrencyIso());
    }

    @Test
    void testOfferCommandAllArgsConstructor() {
        // Arrange
        OfferCommand offerCommand = new OfferCommand(1, "01/01/2023 10:00", "31/12/2023 10:00", 100, "123456789", 1, BigDecimal.valueOf(99.99), "EUR");

        // Assert
        assertEquals(1, offerCommand.getBrandId());
        assertEquals("01/01/2023 10:00", offerCommand.getStartDate());
        assertEquals("31/12/2023 10:00", offerCommand.getEndDate());
        assertEquals(100, offerCommand.getPriceListId());
        assertEquals("123456789", offerCommand.getProductPartNumber());
        assertEquals(1, offerCommand.getPriority());
        assertEquals(BigDecimal.valueOf(99.99), offerCommand.getPrice());
        assertEquals("EUR", offerCommand.getCurrencyIso());
    }
}
