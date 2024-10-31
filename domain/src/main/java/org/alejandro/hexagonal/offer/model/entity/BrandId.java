package org.alejandro.hexagonal.offer.model.entity;

import org.alejandro.hexagonal.offer.model.exception.OfferArgumentNotValidException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;

import java.util.Objects;

public class BrandId {
    private final Integer id;

    public BrandId(Integer brandId) {

        if(Objects.isNull(brandId)){
            throw new OfferArgumentNotValidException(
                    ErrorCatalog.INVALID_NULL_PARAMETER_OFFER.getCode(),
                    String.format(ErrorCatalog.INVALID_NULL_PARAMETER_OFFER.getMessage(), BrandId.class.getSimpleName()));
        }
        this.id = brandId;
    }

    public Integer getId() {

        return id;
    }
}
