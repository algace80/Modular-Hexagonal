package org.alejandro.hexagonal.offer.adapter.mapper;

import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.adapter.entity.OfferEntity;
import org.springframework.stereotype.Component;


@Component
public class OfferDboMapper {

    public OfferEntity toDboCreate(Offer domain){
        if(domain == null){
            return null;
        }
        return new OfferEntity(
                domain.getBrandId().getId(),
                domain.getStartDate().returnStartDateForEntity(),
                domain.getEndDate().returnEndDateForEntity(),
                domain.getPriceListId().getValueListId(),
                domain.getProductPartNumber().getSize().getValueSize(),
                domain.getProductPartNumber().getModel().getValueModel(),
                domain.getProductPartNumber().getQuality().getValueQuality(),
                domain.getPriority().getValuePriority(),
                domain.getPrice().getValuePrice(),
                domain.getCurrencyIso().getValueCurrencyIso());
    }

    public OfferEntity toDboUpdate(Offer domain){
        if(domain == null){
            return null;
        }
        return new OfferEntity(
                domain.getOfferId().getId(),
                domain.getBrandId().getId(),
                domain.getStartDate().returnStartDateForEntity(),
                domain.getEndDate().returnEndDateForEntity(),
                domain.getPriceListId().getValueListId(),
                domain.getProductPartNumber().getSize().getValueSize(),
                domain.getProductPartNumber().getModel().getValueModel(),
                domain.getProductPartNumber().getQuality().getValueQuality(),
                domain.getPriority().getValuePriority(),
                domain.getPrice().getValuePrice(),
                domain.getCurrencyIso().getValueCurrencyIso());
    }

    public Offer toDomain(OfferEntity entity){

        if(entity == null){
            return null;
        }

        return new Offer(entity.getId(),
                entity.getBrandId(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getPriceListId(),
                entity.getSize(),
                entity.getModel(),
                entity.getQuality(),
                entity.getPriority(),
                entity.getPrice(),
                entity.getCurrencyIso());
    }
}
