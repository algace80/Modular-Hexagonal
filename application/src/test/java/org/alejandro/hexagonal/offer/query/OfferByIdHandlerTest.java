package org.alejandro.hexagonal.offer.query;

import org.alejandro.hexagonal.offer.model.dto.OfferDto;
import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.mapper.OfferDtoMapper;
import org.alejandro.hexagonal.offer.port.in.rest.OfferByIdService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OfferByIdHandlerTest {

    @Mock
    private OfferByIdService offerByIdService;

    @Mock
    private OfferDtoMapper offerDtoMapper;

    @InjectMocks
    private OfferByIdHandler offerByIdHandler;

    public OfferByIdHandlerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecute() {
        // Arrange
        Long offerId = 1L;
        Offer offer = new Offer();
        OfferDto expectedOfferDto = new OfferDto();

        when(offerByIdService.execute(offerId)).thenReturn(offer);
        when(offerDtoMapper.toDto(offer)).thenReturn(expectedOfferDto);

        // Act
        OfferDto result = offerByIdHandler.execute(offerId);

        // Assert
        assertEquals(expectedOfferDto, result);
        verify(offerByIdService).execute(offerId);
        verify(offerDtoMapper).toDto(offer);
    }
}
