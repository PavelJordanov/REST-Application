package com.example.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Product;
import com.example.springboot.repository.ProductRepository;
import com.example.springboot.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }
    public Product findById(String id) {
        return repository.findById(id);
    }
    public void deleteById(String id) {
        repository.deleteById(id);
    }
    public int insert(Product product) {
        return repository.insert(product);
    }
    public int update(Product product) {
        return repository.update(product);
    }

}
