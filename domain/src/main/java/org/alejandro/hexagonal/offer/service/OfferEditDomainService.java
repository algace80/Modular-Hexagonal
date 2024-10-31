package org.alejandro.hexagonal.offer.service;


import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.model.dto.command.OfferCommand;
import org.alejandro.hexagonal.offer.port.in.rest.OfferEditService;
import org.alejandro.hexagonal.offer.port.out.dao.OfferDao;
import org.alejandro.hexagonal.offer.port.out.repository.OfferRepository;

public class OfferEditDomainService implements OfferEditService {
    private final OfferDao offerDao;
    private final OfferRepository offerRepository;

    public OfferEditDomainService(OfferDao offerDao, OfferRepository offerRepository) {
        this.offerDao = offerDao;
        this.offerRepository = offerRepository;
    }

    @Override
    public Offer execute(OfferCommand offerCommand, Long id){

        Offer currentOffer = offerDao.getById(id);

        Offer offerToUpdate = new Offer().toUpdate(
                currentOffer.getOfferId().getId(),
                offerCommand.getBrandId(),
                offerCommand.getStartDate(),
                offerCommand.getEndDate(),
                offerCommand.getPriceListId(),
                offerCommand.getProductPartNumber(),
                offerCommand.getPriority(),
                offerCommand.getPrice(),
                offerCommand.getCurrencyIso());

        return offerRepository.update(offerToUpdate);

    }

}
