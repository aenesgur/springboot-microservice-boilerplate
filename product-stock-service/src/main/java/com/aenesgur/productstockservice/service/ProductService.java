package com.aenesgur.productstockservice.service;

import com.aenesgur.productstockservice.model.dto.CreateProductDto;

import java.util.List;

public interface ProductService {
    //ProductResponseDto getById(Long id);
    void create(CreateProductDto createProductDto);
    //List<ProductResponseDto> getProducts();
}
