package org.alejandro.hexagonal.offer.model.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OfferCommand {
    private Integer brandId;
    private String startDate;
    private String endDate;
    private Integer priceListId;
    private String productPartNumber;
    private Integer priority;
    private BigDecimal price;
    private String currencyIso;
}
