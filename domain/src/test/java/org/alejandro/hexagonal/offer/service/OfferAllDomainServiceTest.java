package org.alejandro.hexagonal.offer.service;

import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.port.out.dao.OfferDao;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OfferAllDomainServiceTest {

    @Mock
    private OfferDao offerDao;

    @InjectMocks
    private OfferAllDomainService offerAllDomainService;

    public OfferAllDomainServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecute() {
        // Arrange
        Offer offer1 = new Offer();
        Offer offer2 = new Offer();
        List<Offer> expectedOffers = Arrays.asList(offer1, offer2);

        when(offerDao.getAll()).thenReturn(expectedOffers);

        // Act
        List<Offer> result = offerAllDomainService.execute();

        // Assert
        assertEquals(expectedOffers, result);
        verify(offerDao).getAll();
    }
}
