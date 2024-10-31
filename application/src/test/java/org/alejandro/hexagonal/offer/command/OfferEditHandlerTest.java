package org.alejandro.hexagonal.offer.command;

import org.alejandro.hexagonal.offer.model.dto.OfferDto;
import org.alejandro.hexagonal.offer.model.dto.command.OfferCommand;
import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.mapper.OfferDtoMapper;
import org.alejandro.hexagonal.offer.port.in.rest.OfferEditService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OfferEditHandlerTest {

    @Mock
    private OfferEditService offerEditService;

    @Mock
    private OfferDtoMapper offerDtoMapper;

    @InjectMocks
    private OfferEditHandler offerEditHandler;

    public OfferEditHandlerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecute() {
        // Arrange
        OfferCommand offerEditCommand = new OfferCommand();
        Long offerId = 1L;
        OfferDto expectedOfferDto = new OfferDto();
        Offer offerFromService = new Offer();

        when(offerEditService.execute(offerEditCommand, offerId)).thenReturn(offerFromService);
        when(offerDtoMapper.toDto(offerFromService)).thenReturn(expectedOfferDto);

        // Act
        OfferDto result = offerEditHandler.execute(offerEditCommand, offerId);

        // Assert
        assertEquals(expectedOfferDto, result);
        verify(offerEditService).execute(offerEditCommand, offerId);
        verify(offerDtoMapper).toDto(offerFromService);
    }
}
