package org.alejandro.hexagonal.offer.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Getter
@NoArgsConstructor
public class Offer {

    private static final long serialVersionUID = 448171649369562796L;

    private OfferId offerId;

    private BrandId brandId;

    private StartDate startDate;

    private EndDate endDate;

    private PriceListId priceListId;

    private ProductPartNumber productPartNumber;

    private Priority priority;

    private Price price;

    private Currency currencyIso;

    public Offer(Long offerId, Integer brandId, Timestamp startDate, Timestamp endDate,
                 Integer priceListId, String productPartNumber,
                 Integer priority, BigDecimal price, String currencyIso) {
        this.offerId = new OfferId(offerId);
        this.brandId = new BrandId(brandId);
        this.startDate = new StartDate(startDate);
        this.endDate = new EndDate(endDate);
        this.priceListId = new PriceListId(priceListId);
        this.productPartNumber = new ProductPartNumber(productPartNumber);
        this.priority = new Priority(priority);
        this.price = new Price(price);
        this.currencyIso = new Currency(currencyIso);
    }

    public Offer(Long offerId, Integer brandId, Timestamp startDate, Timestamp endDate,
                 Integer priceListId, String size, String model, String quality,
                 Integer priority, BigDecimal price, String currencyIso) {
        this.offerId = new OfferId(offerId);
        this.brandId = new BrandId(brandId);
        this.startDate = new StartDate(startDate);
        this.endDate = new EndDate(endDate);
        this.priceListId = new PriceListId(priceListId);
        this.productPartNumber = new ProductPartNumber(size, model, quality);
        this.priority = new Priority(priority);
        this.price = new Price(price);
        this.currencyIso = new Currency(currencyIso);
    }

    public Offer toCreate(Integer brandId, String startDate, String endDate, Integer priceListId, String productPartnumber,
                 Integer priority, BigDecimal price, String currencyIso) {
        this.brandId = new BrandId(brandId);
        this.startDate = new StartDate(startDate);
        this.endDate = new EndDate(endDate);
        this.priceListId = new PriceListId(priceListId);
        this.productPartNumber = new ProductPartNumber(productPartnumber);
        this.priority = new Priority(priority);
        this.price = new Price(price);
        this.currencyIso = new Currency(currencyIso);

        return this;
    }

    public Offer toUpdate(Long offerId, Integer brandId, String startDate, String endDate, Integer priceListId, String productPartnumber,
                          Integer priority, BigDecimal price, String currencyIso) {
        this.offerId = new OfferId(offerId);
        this.brandId = new BrandId(brandId);
        this.startDate = new StartDate(startDate);
        this.endDate = new EndDate(endDate);
        this.priceListId = new PriceListId(priceListId);
        this.productPartNumber = new ProductPartNumber(productPartnumber);
        this.priority = new Priority(priority);
        this.price = new Price(price);
        this.currencyIso = new Currency(currencyIso);

        return this;
    }

}
