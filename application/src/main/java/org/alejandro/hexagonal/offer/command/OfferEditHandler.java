package org.alejandro.hexagonal.offer.command;

import org.alejandro.hexagonal.offer.model.dto.command.OfferCommand;
import org.alejandro.hexagonal.offer.model.dto.OfferDto;
import org.alejandro.hexagonal.offer.mapper.OfferDtoMapper;
import org.alejandro.hexagonal.offer.port.in.rest.OfferEditService;
import org.springframework.stereotype.Component;

@Component
public class OfferEditHandler {

    private final OfferEditService offerEditService;
    private final OfferDtoMapper offerDtoMapper;

    public OfferEditHandler(OfferEditService offerEditService, OfferDtoMapper offerDtoMapper) {
        this.offerEditService = offerEditService;
        this.offerDtoMapper = offerDtoMapper;
    }

    public OfferDto execute(OfferCommand offerEditCommand, Long id){
        return offerDtoMapper.toDto(offerEditService.execute(offerEditCommand, id)) ;
    }

}
