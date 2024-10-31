package org.alejandro.hexagonal.offer.model.entity;

import lombok.Getter;
import org.alejandro.hexagonal.offer.model.exception.OfferArgumentNotValidException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;

import java.util.Objects;

@Getter
public class ProductPartNumber {

    private final Size size;

    private final Model model;

    private final Quality quality;

    public ProductPartNumber(String productPartnumber){
        if(Objects.isNull(productPartnumber)){
            throw new OfferArgumentNotValidException(
                    ErrorCatalog.INVALID_NULL_PARAMETER_OFFER.getCode(),
                    String.format(ErrorCatalog.INVALID_NULL_PARAMETER_OFFER.getMessage(), ProductPartNumber.class.getSimpleName()));
        }

        if(productPartnumber.length() != 9){
            throw new OfferArgumentNotValidException(
                    ErrorCatalog.INVALID_LENGTH_OFFER.getCode(),
                    String.format(ErrorCatalog.INVALID_LENGTH_OFFER.getMessage(), ProductPartNumber.class.getSimpleName(), 9));
        }

        this.size = new Size(productPartnumber);
        this.model =  new Model(productPartnumber);
        this.quality = new Quality(productPartnumber);
    }

    public ProductPartNumber(String size, String model, String quality){
        this.size = new Size(size);
        this.model =  new Model(model);
        this.quality = new Quality(quality);
    }

    public String getValueProductPartNumber(){

        return new StringBuffer()
                .append(this.size.getValueSize())
                .append(this.model.getValueModel())
                .append(this.quality.getValueQuality()).toString();
    }

    public static class Size {

        private final String size;

        public Size (String productPartnumber){
            if(productPartnumber.length() > 2) {
                this.size = productPartnumber.substring(0, 2);
            }else{
                this.size = productPartnumber;
            }
        }

        public String getValueSize() {
            return this.size;
        }
    }

    public static class Model {

        private final String model;

        public Model (String productPartnumber){
            if(productPartnumber.length() > 4) {
                this.model = productPartnumber.substring(2, 6);
            }else{
                this.model = productPartnumber;
            }
        }

        public String getValueModel() {
            return this.model;
        }
    }


    public static class Quality {

        private final String quality;

        public Quality (String productPartnumber){
            if(productPartnumber.length() > 3) {
                this.quality = productPartnumber.substring(6, 9);
            }else{
                this.quality = productPartnumber;
            }

        }

        public String getValueQuality(){

            return this.quality;
        }
    }

}
