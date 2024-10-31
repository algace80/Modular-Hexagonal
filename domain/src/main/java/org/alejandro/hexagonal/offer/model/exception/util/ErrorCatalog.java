package org.alejandro.hexagonal.offer.model.exception.util;


import lombok.Getter;

@Getter
public enum ErrorCatalog {

    OFFER_NOT_FOUND("ERR_OFFER_01", "Offer not found"),
    INVALID_NULL_PARAMETER_OFFER("ERR_OFFER_02_01", "Invalid offer parameter. %s can't be null"),
    INVALID_LENGTH_OFFER("ERR_OFFER_02_02", "Invalid offer parameter. The length of %s should be %s"),
    INVALID_SIZE_OFFER("ERR_OFFER_02_03", "Invalid offer parameter. The size of %s should be greater than %s"),
    INVALID_DATE_FORMAT_OFFER("ERR_OFFER_02_04", "Invalid offer parameter. The %s format should be dd/MM/yyyy HH:mm"),
    INVALID_CUERRENCY_OFFER("ERR_OFFER_02_05", "Invalid offer parameter. The %s format should be EUR or USD"),
    GENERIC_ERROR("ERR_GEN_01", "An unexpected error occurred");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
