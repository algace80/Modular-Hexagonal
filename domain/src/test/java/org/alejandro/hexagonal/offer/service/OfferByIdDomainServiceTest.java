package org.alejandro.hexagonal.offer.service;

import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.port.out.dao.OfferDao;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OfferByIdDomainServiceTest {

    @Mock
    private OfferDao offerDao;

    @InjectMocks
    private OfferByIdDomainService offerByIdDomainService;

    public OfferByIdDomainServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecute() {
        // Arrange
        Long offerId = 1L;
        Offer expectedOffer = new Offer();

        when(offerDao.getById(offerId)).thenReturn(expectedOffer);

        // Act
        Offer result = offerByIdDomainService.execute(offerId);

        // Assert
        assertEquals(expectedOffer, result);
        verify(offerDao).getById(offerId);
    }
}
