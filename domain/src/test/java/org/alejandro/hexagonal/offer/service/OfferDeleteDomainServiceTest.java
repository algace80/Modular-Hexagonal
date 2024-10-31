package org.alejandro.hexagonal.offer.service;

import org.alejandro.hexagonal.offer.model.entity.Offer;
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

class OfferDeleteDomainServiceTest {

    @Mock
    private OfferDao offerDao;

    @Mock
    private OfferRepository offerRepository;

    @InjectMocks
    private OfferDeleteDomainService offerDeleteDomainService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecuteById() {
        // Arrange
        Long offerId = 1L;
        Offer offer = new Offer(offerId, 1, Timestamp.valueOf("2023-01-01 00:00:00"),
                Timestamp.valueOf("2023-12-01 00:00:00"), 1, "012543443",
                1, BigDecimal.valueOf(100.0), "USD");

        when(offerDao.getById(offerId)).thenReturn(offer);

        // Act
        offerDeleteDomainService.execute(offerId);

        // Assert
        verify(offerDao).getById(offerId);
        verify(offerRepository).deleteById(offerId);
    }


    @Test
    void testExecuteDeleteAll() {
        // Act
        offerDeleteDomainService.execute();

        // Assert
        verify(offerRepository).deleteAll();
    }
}
