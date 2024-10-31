package org.alejandro.hexagonal.offer.rest.controller;

import org.alejandro.hexagonal.offer.model.dto.OfferDto;
import org.alejandro.hexagonal.offer.query.OfferAllHandler;
import org.alejandro.hexagonal.offer.query.OfferByIdHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offers")
public class OfferQueryController {

    private final OfferByIdHandler offerByIdHandler;
    private final OfferAllHandler offerAllHandler;

    public OfferQueryController(OfferByIdHandler offerByIdHandler, OfferAllHandler offerAllHandler) {
        this.offerByIdHandler = offerByIdHandler;
        this.offerAllHandler = offerAllHandler;
    }

    @GetMapping("/{id}")
    public OfferDto getById(@PathVariable long id){

        return offerByIdHandler.execute(id);
    }

    @GetMapping
    public List<OfferDto> getAll() {
        return offerAllHandler.execute();
    }

}
