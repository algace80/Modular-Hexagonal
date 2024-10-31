package org.alejandro.hexagonal.offer.model.exception;

public class OfferArgumentNotValidException extends RuntimeException{

    private static final long serialVersionUID = 2L;

    private String errorCode;
    private String errorMessage;

    public OfferArgumentNotValidException(String errorCode, String errorMessage) {

        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
