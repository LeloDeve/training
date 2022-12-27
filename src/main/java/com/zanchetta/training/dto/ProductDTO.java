package com.zanchetta.training.dto;

import com.zanchetta.training.domain.Product;

import java.io.Serializable;

public class ProductDTO implements Serializable {

    private String id;
    private String name;
    private Double price;
    private Integer quantity;

    public ProductDTO() {

    }
    public ProductDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
