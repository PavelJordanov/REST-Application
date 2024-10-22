package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("/user")
public class UserController {
    
    private Map<String, User> users = new HashMap<>();

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(new ArrayList<>(users.values()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = users.get(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(users.get(id));
        }
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
		user.setId(UUID.randomUUID().toString());
		users.put(user.getId(), user);
		System.out.println(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable String id, @RequestBody User user) {
		user.setId(id);
		users.put(id, user);
		System.out.println(users);
		return ResponseEntity.ok(user);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable String id) {
		users.remove(id);
		System.out.println(users);
		return ResponseEntity.ok().build();
	}

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUserFieldById(@PathVariable String id, @RequestBody Map<String, Object> updates) {      
        User existingUser = users.get(id);
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        // Iterate over the map and update fields in the existing user object
        updates.forEach((key, value) -> {
            // Use reflection or conditionals to set the appropriate fields
            switch (key) {
                case "firstname":
                    existingUser.setFirstname((String) value);
                    break;
                case "lastname":
                    existingUser.setLastname((String) value);
                    break;
                case "dob":
                    existingUser.setDob((String) value);
                    break;
                case "username":
                    existingUser.setUsername((String) value);
                    break;
                case "password":
                    existingUser.setPassword((String) value);
                    break;
            }
        });

        users.put(id, existingUser);
        return ResponseEntity.ok(existingUser);
    }

}
