package org.alejandro.hexagonal.offer.service;


import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.port.in.rest.OfferByIdService;
import org.alejandro.hexagonal.offer.port.out.dao.OfferDao;

public class OfferByIdDomainService implements OfferByIdService {

    private final OfferDao offerDao;

    public OfferByIdDomainService(OfferDao offerDao) {
        this.offerDao = offerDao;
    }

    @Override
    public Offer execute(Long id){

        return offerDao.getById(id);
    }

}
