package com.aenesgur.productservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEventModel {
    private String ref;
    private String name;
    private BigDecimal price;
    private Integer stockCount;
    private Boolean inStock;
}
