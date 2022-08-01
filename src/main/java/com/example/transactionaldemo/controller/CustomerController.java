package com.example.transactionaldemo.controller;

import com.example.transactionaldemo.dto.CustomerInfoRequest;
import com.example.transactionaldemo.entity.Customer;
import com.example.transactionaldemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> saveCustomerInfo(@RequestBody CustomerInfoRequest infoRequest)
            throws Exception {
        Customer customer = customerService.saveCustomerInfo(infoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
}
