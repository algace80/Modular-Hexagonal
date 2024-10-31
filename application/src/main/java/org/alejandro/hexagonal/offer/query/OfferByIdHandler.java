package org.alejandro.hexagonal.offer.query;

import org.alejandro.hexagonal.offer.model.dto.OfferDto;
import org.alejandro.hexagonal.offer.mapper.OfferDtoMapper;
import org.alejandro.hexagonal.offer.port.in.rest.OfferByIdService;
import org.springframework.stereotype.Component;

@Component
public class OfferByIdHandler {

    private final OfferByIdService offerByIdService;
    private final OfferDtoMapper offerDtoMapper;

    public OfferByIdHandler(OfferByIdService offerByIdService, OfferDtoMapper offerDtoMapper) {
        this.offerByIdService = offerByIdService;
        this.offerDtoMapper = offerDtoMapper;
    }

    public OfferDto execute(Long id){
        return offerDtoMapper
                .toDto(offerByIdService.execute(id));
    }

}
