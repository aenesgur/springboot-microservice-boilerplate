package com.aenesgur.orderservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductStockResponseDto extends BaseResponse {
    private List<ProductStockResponse> productStockResponses;
}
