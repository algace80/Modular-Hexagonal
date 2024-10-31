package org.alejandro.hexagonal.offer.adapter.jpa.dao;

import org.alejandro.hexagonal.offer.model.exception.OfferNotFoundException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;
import org.alejandro.hexagonal.offer.adapter.entity.OfferEntity;
import org.alejandro.hexagonal.offer.adapter.jpa.OfferSpringJpaAdapterRepository;
import org.alejandro.hexagonal.offer.adapter.mapper.OfferDboMapper;
import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OfferH2DaoTest {

    @Mock
    private OfferSpringJpaAdapterRepository offerSpringJpaAdapterRepository;

    @Mock
    private OfferDboMapper offerDboMapper;

    @InjectMocks
    private OfferH2Dao offerH2Dao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetById_WhenOfferExists() {
        // Arrange
        Long offerId = 1L;
        OfferEntity offerEntity = new OfferEntity();
        offerEntity.setId(offerId);
        offerEntity.setBrandId(1);
        offerEntity.setStartDate(Timestamp.valueOf("2024-06-14 00:00:00"));
        offerEntity.setEndDate(Timestamp.valueOf("2024-06-14 00:00:00"));
        offerEntity.setPriceListId(1);
        offerEntity.setSize("00");
        offerEntity.setModel("0100");
        offerEntity.setQuality("233");
        offerEntity.setPriority(1);
        offerEntity.setPrice(BigDecimal.valueOf(35.5));
        offerEntity.setCurrencyIso("EUR");

        // Simulando el mapeo
        Offer offer = new Offer(offerId, 1,
                Timestamp.valueOf("2024-06-14 00:00:00"),
                Timestamp.valueOf("2024-06-14 00:00:00"),
                1, "000100233",
                1, BigDecimal.valueOf(35.5), "EUR");

        when(offerSpringJpaAdapterRepository.findById(offerId)).thenReturn(Optional.of(offerEntity));
        when(offerDboMapper.toDomain(offerEntity)).thenReturn(offer);

        // Act
        Offer result = offerH2Dao.getById(offerId);

        // Assert
        assertEquals(offerId, result.getOfferId().getId());
        verify(offerSpringJpaAdapterRepository, times(1)).findById(offerId);
    }

    @Test
    void testGetById_WhenOfferDoesNotExist() {
        // Arrange
        Long offerId = 1L;
        when(offerSpringJpaAdapterRepository.findById(offerId)).thenReturn(Optional.empty());

        // Act & Assert
        OfferNotFoundException exception = assertThrows(OfferNotFoundException.class, () -> {
            offerH2Dao.getById(offerId);
        });
        assertEquals(ErrorCatalog.OFFER_NOT_FOUND.getCode() , exception.getErrorCode());
        assertEquals(ErrorCatalog.OFFER_NOT_FOUND.getMessage() , exception.getErrorMessage());
    }

    @Test
    void testGetAll() {
        // Arrange
        OfferEntity offerEntity1 = new OfferEntity();
        offerEntity1.setId(1L);
        offerEntity1.setBrandId(1);
        offerEntity1.setStartDate(Timestamp.valueOf("2024-06-14 00:00:00"));
        offerEntity1.setEndDate(Timestamp.valueOf("2024-06-14 00:00:00"));
        offerEntity1.setPriceListId(1);
        offerEntity1.setSize("00");
        offerEntity1.setModel("0100");
        offerEntity1.setQuality("233");
        offerEntity1.setPriority(1);
        offerEntity1.setPrice(BigDecimal.valueOf(35.5));
        offerEntity1.setCurrencyIso("EUR");

        OfferEntity offerEntity2 = new OfferEntity();
        offerEntity2.setId(2L);
        offerEntity2.setBrandId(2);
        offerEntity2.setStartDate(Timestamp.valueOf("2024-06-15 00:00:00"));
        offerEntity2.setEndDate(Timestamp.valueOf("2024-06-15 00:00:00"));
        offerEntity2.setPriceListId(2);
        offerEntity2.setSize("00");
        offerEntity2.setModel("0200");
        offerEntity2.setQuality("234");
        offerEntity2.setPriority(2);
        offerEntity2.setPrice(BigDecimal.valueOf(45.5));
        offerEntity2.setCurrencyIso("USD");

        when(offerSpringJpaAdapterRepository.findAll()).thenReturn(Arrays.asList(offerEntity1, offerEntity2));

        Offer offer1 = new Offer(1L, 1,
                Timestamp.valueOf("2024-06-14 00:00:00"),
                Timestamp.valueOf("2024-06-14 00:00:00"),
                1, "000100233",
                1, BigDecimal.valueOf(35.5), "EUR");
        Offer offer2 = new Offer(2L, 2,
                Timestamp.valueOf("2024-06-15 00:00:00"),
                Timestamp.valueOf("2024-06-15 00:00:00"),
                2, "000200234",
                2, BigDecimal.valueOf(45.5), "USD");

        when(offerDboMapper.toDomain(offerEntity1)).thenReturn(offer1);
        when(offerDboMapper.toDomain(offerEntity2)).thenReturn(offer2);

        // Act
        List<Offer> result = offerH2Dao.getAll();

        // Assert
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getOfferId().getId());
        assertEquals(2L, result.get(1).getOfferId().getId());
        verify(offerSpringJpaAdapterRepository, times(1)).findAll();
    }
}
