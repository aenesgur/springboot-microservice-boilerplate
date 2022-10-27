package com.aenesgur.productstockservice.service;

import com.aenesgur.productstockservice.model.dto.CreateProductDto;
import com.aenesgur.productstockservice.model.dto.ProductStockResponse;
import com.aenesgur.productstockservice.model.dto.ProductStockResponseDto;

import java.util.List;

public interface ProductService {
    //ProductResponseDto getById(Long id);
    void create(CreateProductDto createProductDto);
    ProductStockResponseDto checkProductsStock(List<String> productRefs);
    //List<ProductResponseDto> getProducts();
}
