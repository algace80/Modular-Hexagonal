package org.alejandro.hexagonal.offer.service;

import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.model.dto.command.OfferCommand;
import org.alejandro.hexagonal.offer.model.entity.OfferId;
import org.alejandro.hexagonal.offer.port.out.dao.OfferDao;
import org.alejandro.hexagonal.offer.port.out.repository.OfferRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.mockito.Mockito.*;

class OfferEditDomainServiceTest {

    @Mock
    private OfferDao offerDao;

    @Mock
    private OfferRepository offerRepository;

    @InjectMocks
    private OfferEditDomainService offerEditDomainService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecute() {
        // Arrange
        Long offerId = 1L;
        OfferCommand offerCommand = new OfferCommand();
        offerCommand.setBrandId(1);
        offerCommand.setStartDate("01/01/2023 00:00");
        offerCommand.setEndDate("01/12/2023 23:59");
        offerCommand.setPriceListId(1);
        offerCommand.setProductPartNumber("012543443");
        offerCommand.setPriority(1);
        offerCommand.setPrice(BigDecimal.valueOf(100.0));
        offerCommand.setCurrencyIso("USD");

        Offer currentOffer = new Offer(1L, 1, Timestamp.valueOf("2023-01-01 00:00:00"),
                Timestamp.valueOf("2023-12-01 00:00:00"), 1, "012543443",
                1, BigDecimal.valueOf(100.0), "USD");

        when(offerDao.getById(offerId)).thenReturn(currentOffer);
        when(offerRepository.update(any())).thenReturn(currentOffer);

        // Act
        Offer updatedOffer = offerEditDomainService.execute(offerCommand, offerId);

        // Assert
        verify(offerDao).getById(offerId);
        verify(offerRepository).update(any());

    }
}
