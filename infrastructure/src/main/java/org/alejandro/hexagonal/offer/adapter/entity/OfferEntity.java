package org.alejandro.hexagonal.offer.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Offer")
public class OfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BRAND_ID")
    private Integer brandId;

    @Column(name = "START_DATE")
    private Timestamp startDate;

    @Column(name = "END_DATE")
    private Timestamp endDate;

    @Column(name = "PRICE_LIST")
    private Integer priceListId;

    @Column(name = "SIZE")
    private String size;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "QUALITY")
    private String quality;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "CURR")
    private String currencyIso;

    public OfferEntity(Integer brandId, Timestamp startDate, Timestamp endDate, Integer priceListId,
                       String size, String model, String quality, Integer priority, BigDecimal price, String currencyIso) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceListId = priceListId;
        this.size = size;
        this.model = model;
        this.quality = quality;
        this.priority = priority;
        this.price = price;
        this.currencyIso = currencyIso;
    }
}
