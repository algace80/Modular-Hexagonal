package org.alejandro.hexagonal.offer.model.entity;

import org.alejandro.hexagonal.offer.model.exception.OfferArgumentNotValidException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;

import java.util.Objects;

public class PriceListId {

    private final Integer listId;

    public PriceListId(Integer priceListId) {
        if(Objects.isNull(priceListId)){
            throw new OfferArgumentNotValidException(
                    ErrorCatalog.INVALID_NULL_PARAMETER_OFFER.getCode(),
                    String.format(ErrorCatalog.INVALID_NULL_PARAMETER_OFFER.getMessage(), PriceListId.class.getSimpleName()));
        }
        this.listId = priceListId;
    }

    public Integer getValueListId() {
        return listId;
    }
}
