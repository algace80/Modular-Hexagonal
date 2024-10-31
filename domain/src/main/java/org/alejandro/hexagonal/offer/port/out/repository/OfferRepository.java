package org.alejandro.hexagonal.offer.port.out.repository;

import org.alejandro.hexagonal.offer.model.entity.Offer;

public interface OfferRepository {
    Offer create(Offer offer);
    Offer update(Offer offer);
    void deleteById(Long id);
    void deleteAll();
}
