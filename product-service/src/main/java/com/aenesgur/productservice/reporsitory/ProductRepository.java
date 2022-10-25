package com.aenesgur.productservice.reporsitory;

import com.aenesgur.productservice.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
