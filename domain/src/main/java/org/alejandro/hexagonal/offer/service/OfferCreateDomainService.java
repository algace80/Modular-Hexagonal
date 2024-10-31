package org.alejandro.hexagonal.offer.service;

import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.model.dto.command.OfferCommand;
import org.alejandro.hexagonal.offer.port.in.rest.OfferCreateService;
import org.alejandro.hexagonal.offer.port.out.repository.OfferRepository;

public class OfferCreateDomainService implements OfferCreateService {

    private final OfferRepository offerRepository;

    public OfferCreateDomainService(OfferRepository offerRepository) {

        this.offerRepository = offerRepository;
    }

    @Override
    public Offer execute(OfferCommand offerCreateCommand){

        Offer offerToCreate = new Offer().toCreate(
                offerCreateCommand.getBrandId(),
                offerCreateCommand.getStartDate(),
                offerCreateCommand.getEndDate(),
                offerCreateCommand.getPriceListId(),
                offerCreateCommand.getProductPartNumber(),
                offerCreateCommand.getPriority(),
                offerCreateCommand.getPrice(),
                offerCreateCommand.getCurrencyIso());

        return offerRepository.create(offerToCreate);

    }

}
