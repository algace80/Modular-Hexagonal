package org.alejandro.hexagonal.offer.command;

import org.alejandro.hexagonal.offer.model.dto.OfferDto;
import org.alejandro.hexagonal.offer.model.dto.command.OfferCommand;
import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.mapper.OfferDtoMapper;
import org.alejandro.hexagonal.offer.port.in.rest.OfferCreateService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OfferCreateHandlerTest {

    @Mock
    private OfferCreateService offerCreateService;

    @Mock
    private OfferDtoMapper offerDtoMapper;

    @InjectMocks
    private OfferCreateHandler offerCreateHandler;

    public OfferCreateHandlerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecute() {
        // Arrange
        OfferCommand offerCommand = new OfferCommand();
        Offer expectedOffer = new Offer();
        OfferDto expectedOfferDto = new OfferDto();

        when(offerCreateService.execute(offerCommand)).thenReturn(expectedOffer);

        when(offerDtoMapper.toDto(expectedOffer)).thenReturn(expectedOfferDto);

        // Act
        OfferDto result = offerCreateHandler.execute(offerCommand);

        // Assert
        assertNotNull(result);
        assertEquals(expectedOfferDto, result);
        verify(offerCreateService).execute(offerCommand);
        verify(offerDtoMapper).toDto(expectedOffer);
    }
}
