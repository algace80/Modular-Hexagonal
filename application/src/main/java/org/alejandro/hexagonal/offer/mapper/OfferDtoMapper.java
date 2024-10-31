package org.alejandro.hexagonal.offer.mapper;

import org.alejandro.hexagonal.offer.model.dto.OfferDto;
import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface OfferDtoMapper {

    @Mappings({
            @Mapping(target = "offerId", expression = "java(domain.getOfferId().getId())"),
            @Mapping(target = "brandId", expression = "java(domain.getBrandId().getId())"),
            @Mapping(target = "startDate", expression = "java(domain.getStartDate().returnStartDateForDto())"),
            @Mapping(target = "endDate", expression = "java(domain.getEndDate().returnEndDateForDto())"),
            @Mapping(target = "priceListId", expression = "java(domain.getPriceListId().getValueListId())"),
            @Mapping(target = "productPartNumber", expression = "java(domain.getProductPartNumber().getValueProductPartNumber())"),
            @Mapping(target = "priority", expression = "java(domain.getPriority().getValuePriority())"),
            @Mapping(target = "price", expression = "java(domain.getPrice().getValuePrice())"),
            @Mapping(target = "currencyIso", expression = "java(domain.getCurrencyIso().getValueCurrencyIso())")
    })
    OfferDto toDto(Offer domain);

}

