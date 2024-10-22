package com.example.springboot;

import java.util.List;

import com.example.springboot.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
