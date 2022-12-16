package com.zanchetta.training.resoucers;

import com.zanchetta.training.domain.Client;
import com.zanchetta.training.domain.Product;
import com.zanchetta.training.services.ClientService;
import com.zanchetta.training.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productService.findAll();

        return ResponseEntity.ok().body(list);

    }
    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable String id){
        Product product = productService.findById(id);
        return  ResponseEntity.ok().body(product);
    }

}
