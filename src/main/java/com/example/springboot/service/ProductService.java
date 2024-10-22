package com.example.springboot;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();
    public Product findById(String id);
    public void deleteById(String id);
    public int insert(Product product);
    public int update(Product product);

    
}
