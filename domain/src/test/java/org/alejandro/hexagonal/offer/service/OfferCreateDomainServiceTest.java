package org.alejandro.hexagonal.offer.service;

import org.alejandro.hexagonal.offer.model.dto.command.OfferCommand;
import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.port.out.repository.OfferRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OfferCreateDomainServiceTest {

    @Mock
    private OfferRepository offerRepository;

    @InjectMocks
    private OfferCreateDomainService offerCreateDomainService;

    public OfferCreateDomainServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecute() {
        // Arrange
        OfferCommand offerCommand = new OfferCommand();
        offerCommand.setBrandId(1);
        offerCommand.setStartDate("01/01/2023 00:00");
        offerCommand.setEndDate("01/12/2023 23:59");
        offerCommand.setPriceListId(1);
        offerCommand.setProductPartNumber("012543443");
        offerCommand.setPriority(1);
        offerCommand.setPrice(BigDecimal.valueOf(100.0));
        offerCommand.setCurrencyIso("USD");

        Offer expectedOffer = new Offer();
        expectedOffer.toCreate(
                offerCommand.getBrandId(),
                offerCommand.getStartDate(),
                offerCommand.getEndDate(),
                offerCommand.getPriceListId(),
                offerCommand.getProductPartNumber(),
                offerCommand.getPriority(),
                offerCommand.getPrice(),
                offerCommand.getCurrencyIso());

        when(offerRepository.create(any(Offer.class))).thenReturn(expectedOffer);

        // Act
        Offer result = offerCreateDomainService.execute(offerCommand);

        // Assert
        assertEquals(expectedOffer, result);
        verify(offerRepository).create(any(Offer.class));
    }
}
