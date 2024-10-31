package org.alejandro.hexagonal.offer.model.entity;


import org.alejandro.hexagonal.offer.model.constant.OfferConstant;
import org.alejandro.hexagonal.offer.model.exception.OfferArgumentNotValidException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;

import java.util.Arrays;
import java.util.Objects;

public class Currency {

    private final String currencyIso;

    public Currency(String currencyIso) {
        if(Objects.nonNull(currencyIso) &&
                Arrays.stream(OfferConstant.CURRENCIES).noneMatch(currency -> currency.equals(currencyIso))){
            throw new OfferArgumentNotValidException(
                    ErrorCatalog.INVALID_CUERRENCY_OFFER.getCode(),
                    String.format(ErrorCatalog.INVALID_CUERRENCY_OFFER.getMessage(), Currency.class.getSimpleName()));
        }
        this.currencyIso = currencyIso;
    }

    public String getValueCurrencyIso() {
        return currencyIso;
    }

}
