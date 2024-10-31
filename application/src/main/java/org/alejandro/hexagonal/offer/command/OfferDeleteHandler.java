package org.alejandro.hexagonal.offer.command;

import org.alejandro.hexagonal.offer.port.in.rest.OfferDeleteService;
import org.springframework.stereotype.Component;

@Component
public class OfferDeleteHandler {

    private final OfferDeleteService offerDeleteService;

    public OfferDeleteHandler(OfferDeleteService offerDeleteService) {
        this.offerDeleteService = offerDeleteService;
    }

    public void execute(Long id){
        offerDeleteService.execute(id);
    }

    public void execute(){
        offerDeleteService.execute();
    }

}
