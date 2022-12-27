package com.zanchetta.training.services;

import com.zanchetta.training.domain.Product;
import com.zanchetta.training.dto.ProductDTO;
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

    public List<Product> findAll() {
        return productRepository.findAll();

    }

    public Product findById(String id) {
        Optional<Product> product = productRepository.findById(id); //se nao encontrar o id ele retorna nulo
        //if (client == null){
        //   throw new ObjectNotFoundException("Objeto nao encontrado");
        //}
        return product.orElseThrow(() -> new ObjectNotFoundException("Produto nao encontrado"));
    }

    public Product insert(Product product) { //metodo retorna um cliente inserido no db
        return productRepository.insert(product);
    }

    public void delete(String id) { //metodo recebe um id, procura por id e deleta pelo id encontrado
        findById(id);
        productRepository.deleteById(id);
    }

    public Product update(Product product) {
        Product newProduct = findById(product.getId());
        updateData(newProduct, product);
        return productRepository.save(newProduct);

    }

    private void updateData(Product newProduct, Product product) {
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantity(product.getQuantity());

    }

    public Product productFromDTO(ProductDTO productDTO) {
        return new Product(productDTO.getId(), productDTO.getName(), productDTO.getPrice(), productDTO.getQuantity());

    }

}
