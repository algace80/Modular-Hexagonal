package org.alejandro.hexagonal.beanconfiguration;


import org.alejandro.hexagonal.offer.port.in.rest.*;
import org.alejandro.hexagonal.offer.port.out.dao.OfferDao;
import org.alejandro.hexagonal.offer.port.out.repository.OfferRepository;
import org.alejandro.hexagonal.offer.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferBean {
    
    @Bean
    public OfferAllService offerAllService(OfferDao offerDao){
        return new OfferAllDomainService(offerDao);
    }

    @Bean
    public OfferByIdService offerByIdService(OfferDao offerDao){
        return new OfferByIdDomainService(offerDao);
    }

    @Bean
    public OfferCreateService offerCreateService(OfferRepository offerRepository){
        return new OfferCreateDomainService(offerRepository);
    }

    @Bean
    public OfferDeleteService offerDeleteService(OfferDao offerDao, OfferRepository offerRepository){
        return new OfferDeleteDomainService(offerDao, offerRepository);
    }

    @Bean
    public OfferEditService offerEditService(OfferDao offerDao, OfferRepository offerRepository){
        return new OfferEditDomainService(offerDao, offerRepository);
    }

}
