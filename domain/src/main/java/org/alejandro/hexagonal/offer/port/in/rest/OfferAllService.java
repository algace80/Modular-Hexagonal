package org.alejandro.hexagonal.offer.port.in.rest;

import org.alejandro.hexagonal.offer.model.entity.Offer;

import java.util.List;

public interface OfferAllService {
    List<Offer> execute();
}
