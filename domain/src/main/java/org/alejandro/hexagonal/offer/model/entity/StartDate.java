package org.alejandro.hexagonal.offer.model.entity;

import org.alejandro.hexagonal.offer.model.constant.OfferConstant;
import org.alejandro.hexagonal.offer.model.exception.OfferArgumentNotValidException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class StartDate {

    private final LocalDateTime date;

    public StartDate(Timestamp startDate){
        this.date = startDate.toLocalDateTime();
    }

    public StartDate(String startDate){
        if(Objects.isNull(startDate)){
            throw new OfferArgumentNotValidException(
                    ErrorCatalog.INVALID_NULL_PARAMETER_OFFER.getCode(),
                    String.format(ErrorCatalog.INVALID_NULL_PARAMETER_OFFER.getMessage(), StartDate.class.getSimpleName()));
        }

        try {
            this.date = LocalDateTime.parse(startDate, DateTimeFormatter.ofPattern(OfferConstant.DATE_TIME_FORMATTER));
        }catch (DateTimeParseException e){
            throw new OfferArgumentNotValidException(
                    ErrorCatalog.INVALID_DATE_FORMAT_OFFER.getCode(),
                    String.format(ErrorCatalog.INVALID_DATE_FORMAT_OFFER.getMessage(), StartDate.class.getSimpleName()));
        }
    }

    public Timestamp returnStartDateForEntity (){
        return Timestamp.valueOf(this.date);
    }

    public String returnStartDateForDto (){
        return this.date.format(DateTimeFormatter.ofPattern(OfferConstant.DATE_TIME_FORMATTER));
    }
}
