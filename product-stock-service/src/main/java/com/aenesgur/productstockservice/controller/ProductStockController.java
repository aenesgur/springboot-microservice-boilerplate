package com.aenesgur.productstockservice.controller;

import com.aenesgur.productstockservice.model.dto.ProductStockResponse;
import com.aenesgur.productstockservice.model.dto.ProductStockResponseDto;
import com.aenesgur.productstockservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product-stocks")
@RequiredArgsConstructor
public class ProductStockController {

    private final ProductService productService;

    // host/api/product-stocks?productRefs=82d45bcf-ebee-4f83-b6cb-4982b7b19717&productRefs=f699dcac-6881-407b-83cf-aa1e92a52fef
    @GetMapping
    public ResponseEntity<ProductStockResponseDto> checkProductsStock(@RequestParam List<String> productRefs){
        return new ResponseEntity<>(productService.checkProductsStock(productRefs), HttpStatus.OK);
    }
}
