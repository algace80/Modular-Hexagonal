package org.alejandro.hexagonal.offer.query;

import org.alejandro.hexagonal.offer.model.dto.OfferDto;
import org.alejandro.hexagonal.offer.mapper.OfferDtoMapper;
import org.alejandro.hexagonal.offer.port.in.rest.OfferAllService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class OfferAllHandler {

    private final OfferAllService offerAllService;
    private final OfferDtoMapper offerDtoMapper;

    public OfferAllHandler(OfferAllService offerAllService, OfferDtoMapper offerDtoMapper) {
        this.offerAllService = offerAllService;
        this.offerDtoMapper = offerDtoMapper;
    }

    public List<OfferDto> execute(){
        return offerAllService.execute()
                .stream()
                .map(offerDtoMapper::toDto)
                .collect(Collectors.toList());
    }

}
