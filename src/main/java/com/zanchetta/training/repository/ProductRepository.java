package com.zanchetta.training.repository;

import com.zanchetta.training.domain.Client;
import com.zanchetta.training.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
