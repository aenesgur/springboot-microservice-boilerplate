package com.aenesgur.productstockservice.service;

import com.aenesgur.productstockservice.model.dto.CreateProductDto;
import com.aenesgur.productstockservice.model.entity.Product;
import com.aenesgur.productstockservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public void create(CreateProductDto createProductDto) {
        productRepository.save(mapToEntity(createProductDto));
    }

    private Product mapToEntity(CreateProductDto createProductDto){
        return Product.builder()
                .ref(createProductDto.getRef())
                .price(createProductDto.getPrice())
                .inStock(createProductDto.getInStock())
                .name(createProductDto.getName())
                .stockCount(createProductDto.getStockCount())
                .build();
    }
}
