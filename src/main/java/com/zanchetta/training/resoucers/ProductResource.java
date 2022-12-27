package com.zanchetta.training.resoucers;

import com.zanchetta.training.domain.Client;
import com.zanchetta.training.domain.Product;
import com.zanchetta.training.dto.ProductDTO;
import com.zanchetta.training.services.ClientService;
import com.zanchetta.training.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<Product> list = productService.findAll();
        List<ProductDTO> listDTO = list.stream().map(x-> new ProductDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);

    }
    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable String id){
        Product product = productService.findById(id);
        return  ResponseEntity.ok().body(product);
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Product product){
        Product obj = productService.insert(product);

        //vai retornar uma messagem/cabeçalho com o caminho do novo recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}
