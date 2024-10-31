package org.alejandro.hexagonal.offer.model.entity;

import lombok.Getter;
import org.alejandro.hexagonal.offer.model.constant.OfferConstant;
import org.alejandro.hexagonal.offer.model.exception.OfferArgumentNotValidException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

@Getter
public class EndDate {

    private final LocalDateTime date;

    public EndDate(Timestamp endDate){
        this.date = endDate.toLocalDateTime();
    }

    public EndDate(String endDate){
        if(Objects.isNull(endDate)){
            throw new OfferArgumentNotValidException(
                    ErrorCatalog.INVALID_NULL_PARAMETER_OFFER.getCode(),
                    String.format(ErrorCatalog.INVALID_NULL_PARAMETER_OFFER.getMessage(), EndDate.class.getSimpleName()));
        }

        try {
            this.date = LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern(OfferConstant.DATE_TIME_FORMATTER));
        }catch (DateTimeParseException e){
            throw new OfferArgumentNotValidException(
                    ErrorCatalog.INVALID_DATE_FORMAT_OFFER.getCode(),
                    String.format(ErrorCatalog.INVALID_DATE_FORMAT_OFFER.getMessage(), EndDate.class.getSimpleName()));
        }
    }

    public Timestamp returnEndDateForEntity (){
        return Timestamp.valueOf(this.date);
    }

    public String returnEndDateForDto (){
        return this.date.format(DateTimeFormatter.ofPattern(OfferConstant.DATE_TIME_FORMATTER));
    }
}
