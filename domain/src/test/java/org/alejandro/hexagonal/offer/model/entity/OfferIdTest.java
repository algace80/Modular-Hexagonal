package org.alejandro.hexagonal.offer.model.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OfferIdTest {

    @Test
    void testOfferIdCreation() {
        // Arrange
        Long expectedId = 123L;

        // Act
        OfferId offerId = new OfferId(expectedId);

        // Assert
        assertEquals(expectedId, offerId.getId());
    }

    @Test
    void testOfferIdWithNull() {
        // Arrange
        Long expectedId = null;

        // Act
        OfferId offerId = new OfferId(expectedId);

        // Assert
        assertEquals(expectedId, offerId.getId());
    }
}
