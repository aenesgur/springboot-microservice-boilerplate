package com.aenesgur.productstockservice.repository;

import com.aenesgur.productstockservice.model.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String > {
    Optional<List<Product>> findByRefIn(List<String> productRefs);
}
