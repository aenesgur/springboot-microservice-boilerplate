package com.aenesgur.productservice.service;

import com.aenesgur.productservice.model.dto.ProductRequestDto;
import com.aenesgur.productservice.model.dto.ProductResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ProductService {
    ProductResponseDto getById(Long id);
    void create(ProductRequestDto productRequestDto);
    List<ProductResponseDto> getProducts();
}
