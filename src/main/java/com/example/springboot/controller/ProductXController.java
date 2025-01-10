package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.http.*;


@RestController
@RequestMapping("/productx")
public class ProductXController {
	
	private Map<String, Product> products = new HashMap<>();

	@GetMapping
    public ResponseEntity<List<Product>> getProducts() {
		return ResponseEntity.ok(new ArrayList<>(products.values()));
	}

	@GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
		Product product = products.get(id);
		if (product == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.ok(products.get(id));
		}
	}

	@PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		product.setId(UUID.randomUUID().toString());
		products.put(product.getId(), product);
		System.out.println(products);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProductById(@PathVariable String id, @RequestBody Product product) {
		product.setId(id);
		products.put(id, product);
		System.out.println(products);
		return ResponseEntity.ok(product);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProductById(@PathVariable String id) {
		products.remove(id);
		System.out.println(products);
		return ResponseEntity.ok().build();
	}

}