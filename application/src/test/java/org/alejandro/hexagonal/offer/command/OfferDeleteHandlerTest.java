package org.alejandro.hexagonal.offer.command;

import org.alejandro.hexagonal.offer.port.in.rest.OfferDeleteService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class OfferDeleteHandlerTest {

    @Mock
    private OfferDeleteService offerDeleteService;

    @InjectMocks
    private OfferDeleteHandler offerDeleteHandler;

    public OfferDeleteHandlerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecute_WithId() {
        // Arrange
        Long offerId = 1L;

        // Act
        offerDeleteHandler.execute(offerId);

        // Assert
        verify(offerDeleteService).execute(offerId);
    }

    @Test
    void testExecute_WithoutId() {
        // Act
        offerDeleteHandler.execute();

        // Assert
        verify(offerDeleteService).execute();
    }
}
