package org.alejandro.hexagonal.offer.adapter.jpa.repository;

import org.alejandro.hexagonal.offer.model.exception.OfferNotFoundException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;
import org.alejandro.hexagonal.offer.adapter.entity.OfferEntity;
import org.alejandro.hexagonal.offer.adapter.mapper.OfferDboMapper;
import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.adapter.jpa.OfferSpringJpaAdapterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OfferH2RepositoryTest {

    @InjectMocks
    private OfferH2Repository offerH2Repository;

    @Mock
    private OfferSpringJpaAdapterRepository offerSpringJpaAdapterRepository;

    @Mock
    private OfferDboMapper offerDboMapper;

    private OfferEntity offerEntity;
    private Offer offer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Configuración de prueba
        offerEntity = new OfferEntity();
        offerEntity.setId(1L);
        offerEntity.setBrandId(1);
        offerEntity.setStartDate(Timestamp.valueOf("2024-06-14 00:00:00"));
        offerEntity.setEndDate(Timestamp.valueOf("2024-06-14 00:00:00"));
        offerEntity.setPriceListId(1);
        offerEntity.setSize("01"); // Dos dígitos para size
        offerEntity.setModel("2543"); // Cuatro dígitos para model
        offerEntity.setQuality("443"); // Tres dígitos para quality
        offerEntity.setPriority(0);
        offerEntity.setPrice(BigDecimal.valueOf(35.5));
        offerEntity.setCurrencyIso("EUR");

        // Crear el productPartNumber
        String productPartNumber = "012543443"; // 2 + 4 + 3
        offer = new Offer(1L, 1, Timestamp.valueOf("2024-06-14 00:00:00"),
                Timestamp.valueOf("2024-06-14 00:00:00"), 1, productPartNumber, 0, BigDecimal.valueOf(35.5), "EUR");
    }

    @Test
    void testCreate() {
        when(offerDboMapper.toDboCreate(offer)).thenReturn(offerEntity);
        when(offerSpringJpaAdapterRepository.save(offerEntity)).thenReturn(offerEntity);
        when(offerDboMapper.toDomain(offerEntity)).thenReturn(offer);

        Offer createdOffer = offerH2Repository.create(offer);

        assertNotNull(createdOffer);
        assertEquals(1L, createdOffer.getOfferId().getId());
        assertEquals("01", offerEntity.getSize());
        assertEquals("2543", offerEntity.getModel());
        assertEquals("443", offerEntity.getQuality());
        verify(offerDboMapper).toDboCreate(offer);
        verify(offerSpringJpaAdapterRepository).save(offerEntity);
        verify(offerDboMapper).toDomain(offerEntity);
    }

    @Test
    void testUpdate_WhenOfferExists() {
        when(offerDboMapper.toDboUpdate(offer)).thenReturn(offerEntity);
        when(offerSpringJpaAdapterRepository.findById(1L)).thenReturn(Optional.of(offerEntity));
        when(offerSpringJpaAdapterRepository.save(offerEntity)).thenReturn(offerEntity);
        when(offerDboMapper.toDomain(offerEntity)).thenReturn(offer);

        Offer updatedOffer = offerH2Repository.update(offer);

        assertNotNull(updatedOffer);
        assertEquals(1L, updatedOffer.getOfferId().getId());
        assertEquals("01", offerEntity.getSize());
        assertEquals("2543", offerEntity.getModel());
        assertEquals("443", offerEntity.getQuality());
        verify(offerSpringJpaAdapterRepository).findById(1L);
        verify(offerSpringJpaAdapterRepository).save(offerEntity);
    }

    @Test
    void testUpdate_WhenOfferDoesNotExist() {
        when(offerDboMapper.toDboUpdate(offer)).thenReturn(offerEntity);
        when(offerSpringJpaAdapterRepository.findById(1L)).thenReturn(Optional.empty());

        OfferNotFoundException exception = assertThrows(OfferNotFoundException.class, () -> {
            offerH2Repository.update(offer);
        });

        assertEquals(ErrorCatalog.OFFER_NOT_FOUND.getCode() , exception.getErrorCode());
        assertEquals(ErrorCatalog.OFFER_NOT_FOUND.getMessage() , exception.getErrorMessage());
    }

    @Test
    void testDeleteById_WhenOfferExists() {
        when(offerSpringJpaAdapterRepository.findById(1L)).thenReturn(Optional.of(offerEntity));

        offerH2Repository.deleteById(1L);

        verify(offerSpringJpaAdapterRepository).deleteById(1L);
    }

    @Test
    void testDeleteById_WhenOfferDoesNotExist() {
        when(offerSpringJpaAdapterRepository.findById(1L)).thenReturn(Optional.empty());

        OfferNotFoundException exception = assertThrows(OfferNotFoundException.class, () -> {
            offerH2Repository.deleteById(1L);
        });

        assertEquals(ErrorCatalog.OFFER_NOT_FOUND.getCode() , exception.getErrorCode());
        assertEquals(ErrorCatalog.OFFER_NOT_FOUND.getMessage() , exception.getErrorMessage());

    }

    @Test
    void testDeleteAll() {
        offerH2Repository.deleteAll();

        verify(offerSpringJpaAdapterRepository).deleteAll();
    }
}
