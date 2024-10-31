package org.alejandro.hexagonal.beanconfiguration;

import org.alejandro.hexagonal.offer.port.in.rest.*;
import org.alejandro.hexagonal.offer.port.out.dao.OfferDao;
import org.alejandro.hexagonal.offer.port.out.repository.OfferRepository;
import org.alejandro.hexagonal.offer.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class OfferBeanTest {

    private OfferBean offerBean;
    private OfferDao offerDao;
    private OfferRepository offerRepository;

    @BeforeEach
    void setUp() {
        offerBean = new OfferBean();
        offerDao = Mockito.mock(OfferDao.class); // Simula el OfferDao
        offerRepository = Mockito.mock(OfferRepository.class); // Simula el OfferRepository
    }

    @Test
    void offerAllService_ShouldReturnOfferAllServiceBean() {
        // Act
        OfferAllService offerAllService = offerBean.offerAllService(offerDao);

        // Assert
        assertNotNull(offerAllService);
        assertTrue(offerAllService instanceof OfferAllDomainService);
    }

    @Test
    void offerByIdService_ShouldReturnOfferByIdServiceBean() {
        // Act
        OfferByIdService offerByIdService = offerBean.offerByIdService(offerDao);

        // Assert
        assertNotNull(offerByIdService);
        assertTrue(offerByIdService instanceof OfferByIdDomainService);
    }

    @Test
    void offerCreateService_ShouldReturnOfferCreateServiceBean() {
        // Act
        OfferCreateService offerCreateService = offerBean.offerCreateService(offerRepository);

        // Assert
        assertNotNull(offerCreateService);
        assertTrue(offerCreateService instanceof OfferCreateDomainService);
    }

    @Test
    void offerDeleteService_ShouldReturnOfferDeleteServiceBean() {
        // Act
        OfferDeleteService offerDeleteService = offerBean.offerDeleteService(offerDao, offerRepository);

        // Assert
        assertNotNull(offerDeleteService);
        assertTrue(offerDeleteService instanceof OfferDeleteDomainService);
    }

    @Test
    void offerEditService_ShouldReturnOfferEditServiceBean() {
        // Act
        OfferEditService offerEditService = offerBean.offerEditService(offerDao, offerRepository);

        // Assert
        assertNotNull(offerEditService);
        assertTrue(offerEditService instanceof OfferEditDomainService);
    }
}
