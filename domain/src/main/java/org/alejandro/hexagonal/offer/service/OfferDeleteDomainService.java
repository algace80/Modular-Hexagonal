package org.alejandro.hexagonal.offer.service;

import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.port.in.rest.OfferDeleteService;
import org.alejandro.hexagonal.offer.port.out.dao.OfferDao;
import org.alejandro.hexagonal.offer.port.out.repository.OfferRepository;


public class OfferDeleteDomainService implements OfferDeleteService {

    private final OfferDao offerDao;
    private final OfferRepository offerRepository;

    public OfferDeleteDomainService(OfferDao offerDao, OfferRepository offerRepository) {
        this.offerDao = offerDao;
        this.offerRepository = offerRepository;
    }

    @Override
    public void execute(Long id){
        Offer offer = offerDao.getById(id);
        offerRepository.deleteById(offer.getOfferId().getId());
    }

    @Override
    public void execute(){
        offerRepository.deleteAll();
    }

}
