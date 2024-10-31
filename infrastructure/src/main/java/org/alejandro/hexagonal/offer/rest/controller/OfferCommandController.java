package org.alejandro.hexagonal.offer.rest.controller;

import org.alejandro.hexagonal.offer.command.OfferCreateHandler;
import org.alejandro.hexagonal.offer.command.OfferDeleteHandler;
import org.alejandro.hexagonal.offer.command.OfferEditHandler;
import org.alejandro.hexagonal.offer.model.dto.OfferDto;
import org.alejandro.hexagonal.offer.model.dto.command.OfferCommand;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/offers")
public class OfferCommandController {

    private final OfferCreateHandler offerCreateHandler;
    private final OfferEditHandler offerEditHandler;
    private final OfferDeleteHandler offerDeleteHandler;

    public OfferCommandController(OfferCreateHandler offerCreateHandler, OfferEditHandler offerEditHandler, OfferDeleteHandler offerDeleteHandler) {
        this.offerCreateHandler = offerCreateHandler;
        this.offerEditHandler = offerEditHandler;
        this.offerDeleteHandler = offerDeleteHandler;
    }

    @PostMapping()
    public OfferDto create(@RequestBody OfferCommand offerCreateCommand){
        return offerCreateHandler.execute(offerCreateCommand);
    }

    @PutMapping("/{id}")
    public OfferDto offerEdit(@RequestBody OfferCommand offerEditCommand, @PathVariable Long id){
        return offerEditHandler.execute(offerEditCommand, id);
    }

    @DeleteMapping("/{id}")
    public void deleteOfferById(@PathVariable Long id){
        offerDeleteHandler.execute(id);
    }

    @DeleteMapping()
    public void deleteAllOffer(){
        offerDeleteHandler.execute();
    }

}
