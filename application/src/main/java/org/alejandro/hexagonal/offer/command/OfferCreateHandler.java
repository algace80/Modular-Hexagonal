package org.alejandro.hexagonal.offer.command;

import org.alejandro.hexagonal.offer.model.dto.OfferDto;
import org.alejandro.hexagonal.offer.model.dto.command.OfferCommand;
import org.alejandro.hexagonal.offer.mapper.OfferDtoMapper;
import org.alejandro.hexagonal.offer.port.in.rest.OfferCreateService;
import org.springframework.stereotype.Component;

@Component
public class OfferCreateHandler {

    private final OfferCreateService offerCreateService;
    private final OfferDtoMapper offerDtoMapper;
    public OfferCreateHandler(OfferCreateService offerCreateService, OfferDtoMapper offerDtoMapper) {
        this.offerCreateService = offerCreateService;
        this.offerDtoMapper = offerDtoMapper;
    }

    public OfferDto execute(OfferCommand offerCreateCommand) {
        return offerDtoMapper.toDto(offerCreateService.execute(offerCreateCommand));
    }

}

