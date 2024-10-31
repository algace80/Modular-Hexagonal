package org.alejandro.hexagonal.offer.port.out.dao;

import org.alejandro.hexagonal.offer.model.entity.Offer;

import java.util.List;

public interface OfferDao {

    Offer getById(Long id);
    List<Offer> getAll();
}
