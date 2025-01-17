package com.example.springboot.controller;

import com.example.springboot.model.Product;
import com.example.springboot.service.ProductService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping
    public ResponseEntity<List<Product>> getProducts() {
		return ResponseEntity.ok(productService.findAll());
	}

	@GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
		Product product = productService.findById(id);
		if (product == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.ok(product);
		}
	}

	@PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		product.setId(UUID.randomUUID().toString());
		productService.insert(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProductById(@PathVariable String id, @RequestBody Product product) {
		product.setId(id);
		productService.update(product);
		return ResponseEntity.ok(product);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProductById(@PathVariable String id) {
		productService.deleteById(id);
		return ResponseEntity.ok().build();
	}


}