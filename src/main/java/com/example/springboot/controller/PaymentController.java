package com.example.springboot.controller;

import com.example.springboot.model.Payment;
import com.example.springboot.service.PaymentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
	PaymentService paymentService;

	@GetMapping
    public ResponseEntity<List<Payment>> getPayments() {
		System.out.println("HERE!!!");
		return ResponseEntity.ok(paymentService.findAll());
	}

	@GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable String id) {
		Payment payment = paymentService.findById(id);
		if (payment == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.ok(payment);
		}
	}

	@PostMapping
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) {
		payment.setId(UUID.randomUUID().toString());
		paymentService.insert(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePaymentById(@PathVariable String id) {
		paymentService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
