package org.alejandro.hexagonal.offer.port.in.rest;

import org.alejandro.hexagonal.offer.model.dto.command.OfferCommand;
import org.alejandro.hexagonal.offer.model.entity.Offer;

public interface OfferEditService {
    Offer execute(OfferCommand offerCommand, Long id);
}
