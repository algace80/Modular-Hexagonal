package org.alejandro.hexagonal.offer.query;

import org.alejandro.hexagonal.offer.model.dto.OfferDto;
import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.mapper.OfferDtoMapper;
import org.alejandro.hexagonal.offer.port.in.rest.OfferAllService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OfferAllHandlerTest {

    @Mock
    private OfferAllService offerAllService;

    @Mock
    private OfferDtoMapper offerDtoMapper;

    @InjectMocks
    private OfferAllHandler offerAllHandler;

    public OfferAllHandlerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecute() {
        // Arrange
        Offer offer1 = new Offer();
        Offer offer2 = new Offer();
        List<Offer> offers = Arrays.asList(offer1, offer2);

        OfferDto offerDto1 = new OfferDto();
        OfferDto offerDto2 = new OfferDto();
        List<OfferDto> expectedOfferDtos = Arrays.asList(offerDto1, offerDto2);

        when(offerAllService.execute()).thenReturn(offers);
        when(offerDtoMapper.toDto(offer1)).thenReturn(offerDto1);
        when(offerDtoMapper.toDto(offer2)).thenReturn(offerDto2);

        // Act
        List<OfferDto> result = offerAllHandler.execute();

        // Assert
        assertEquals(expectedOfferDtos, result);
        verify(offerAllService).execute();
        verify(offerDtoMapper).toDto(offer1);
        verify(offerDtoMapper).toDto(offer2);
    }
}
