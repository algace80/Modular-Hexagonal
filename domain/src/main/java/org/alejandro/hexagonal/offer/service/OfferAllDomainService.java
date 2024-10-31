package org.alejandro.hexagonal.offer.service;

import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.port.in.rest.OfferAllService;
import org.alejandro.hexagonal.offer.port.out.dao.OfferDao;

import java.util.List;

public class OfferAllDomainService implements OfferAllService {

    private final OfferDao offerDao;

    public OfferAllDomainService(OfferDao offerDao) {

        this.offerDao = offerDao;
    }

    @Override
    public List<Offer> execute(){

        return offerDao.getAll();
    }

}
