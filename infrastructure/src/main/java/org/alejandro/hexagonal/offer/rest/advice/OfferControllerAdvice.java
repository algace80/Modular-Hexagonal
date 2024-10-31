package org.alejandro.hexagonal.offer.rest.advice;


import org.alejandro.hexagonal.offer.model.exception.OfferArgumentNotValidException;
import org.alejandro.hexagonal.offer.model.exception.OfferNotFoundException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;


@RestControllerAdvice
public class OfferControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(OfferNotFoundException.class)
    public ErrorResponse handleOfferNotFoundException(OfferNotFoundException exception) {
        return ErrorResponse.builder()
                .code(exception.getErrorCode())
                .message(exception.getErrorMessage())
                .timestamp(LocalDateTime.now()).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(OfferArgumentNotValidException.class)
    public ErrorResponse handleOfferArgumentNotValidException(OfferArgumentNotValidException exception) {
        return ErrorResponse.builder()
                .code(exception.getErrorCode())
                .message(exception.getErrorMessage())
                .timestamp(LocalDateTime.now()).build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGenericError(Exception exception) {
        return ErrorResponse.builder()
                .code(ErrorCatalog.GENERIC_ERROR.getCode())
                .message(ErrorCatalog.GENERIC_ERROR.getMessage())
                .details(Collections.singletonList(exception.getMessage()))
                .timestamp(LocalDateTime.now()).build();
    }

}
