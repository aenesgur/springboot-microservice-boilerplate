package com.aenesgur.productstockservice.service;

import com.aenesgur.productstockservice.model.dto.CreateProductDto;
import com.aenesgur.productstockservice.model.dto.ProductStockResponse;
import com.aenesgur.productstockservice.model.dto.ProductStockResponseDto;
import com.aenesgur.productstockservice.model.entity.Product;
import com.aenesgur.productstockservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public void create(CreateProductDto createProductDto) {
        productRepository.save(mapToEntity(createProductDto));
    }

    @Override
    public ProductStockResponseDto checkProductsStock(List<String> productRefs) {
        Optional<List<Product>> products = productRepository.findByRefIn(productRefs);
        if(products.isPresent() && products.get().size()>0){
            List<ProductStockResponse> productStockResponses = products.get().stream()
                    .map(product ->
                            {
                                return ProductStockResponse.builder()
                                        .ref(product.getRef())
                                        .inStock(product.getStockCount() > 0 ? product.getInStock() : false)
                                        .build();
                            }
                    ).collect(Collectors.toList());
            return ProductStockResponseDto.builder().productStockResponses(productStockResponses).build();
        }
        ProductStockResponseDto productStockResponseDto = new ProductStockResponseDto();
        productStockResponseDto.setProductStockResponses(null);
        productStockResponseDto.setError(true);
        productStockResponseDto.setDescription("Product refs does not contain in database");
        return productStockResponseDto;
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
