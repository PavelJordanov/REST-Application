package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.User;
import com.example.springboot.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping
    public ResponseEntity<List<User>> getUsers() {
		System.out.println("HERE!!!");
		return ResponseEntity.ok(userService.findAll());
	}

	@GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
		User user = userService.findById(id);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.ok(user);
		}
	}

	@PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
		user.setId(UUID.randomUUID().toString());
		userService.insert(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable String id, @RequestBody User user) {
		user.setId(id);
		userService.update(user);
		return ResponseEntity.ok(user);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable String id) {
		userService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}