package com.example.springboot.service;

import java.util.List;

import com.example.springboot.model.Product;

public interface ProductService {

    public List<Product> findAll();
    public Product findById(String id);
    public void deleteById(String id);
    public int insert(Product product);
    public int update(Product product);

    
}
