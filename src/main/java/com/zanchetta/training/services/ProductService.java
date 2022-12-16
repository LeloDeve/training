package com.zanchetta.training.services;

import com.zanchetta.training.domain.Client;
import com.zanchetta.training.domain.Product;
import com.zanchetta.training.repository.ProductRepository;
import com.zanchetta.training.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();

    }
    public Product findById(String id){
        Optional<Product> product = productRepository.findById(id); //se nao encontrar o id ele retorna nulo
        //if (client == null){
        //   throw new ObjectNotFoundException("Objeto nao encontrado");
        //}
        return product.orElseThrow(()-> new ObjectNotFoundException("Produto nao encontrado"));
    }

}
