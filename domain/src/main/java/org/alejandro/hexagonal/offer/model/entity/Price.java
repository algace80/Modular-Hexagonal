package org.alejandro.hexagonal.offer.model.entity;

import org.alejandro.hexagonal.offer.model.exception.OfferArgumentNotValidException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;

import java.math.BigDecimal;
import java.util.Objects;

public class Price {
    private final BigDecimal price;

    public Price(BigDecimal price){
        if(Objects.nonNull(price) && price.compareTo(BigDecimal.ZERO) < 0){
            throw new OfferArgumentNotValidException(
                    ErrorCatalog.INVALID_SIZE_OFFER.getCode(),
                    String.format(ErrorCatalog.INVALID_SIZE_OFFER.getMessage(), Price.class.getSimpleName(), 0));
        }
        this.price = price;
    }

    public BigDecimal getValuePrice() {
        return price;
    }
}
