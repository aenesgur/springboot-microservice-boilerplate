package com.aenesgur.productstockservice.repository;

import com.aenesgur.productstockservice.model.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String > {
}
