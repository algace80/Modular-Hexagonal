package org.alejandro.hexagonal.offer.port.in.rest;

import org.alejandro.hexagonal.offer.model.entity.Offer;

public interface OfferByIdService {
    Offer execute(Long id);
}
