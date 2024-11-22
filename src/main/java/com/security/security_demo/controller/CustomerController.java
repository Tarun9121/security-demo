package com.security.security_demo.controller;

import com.security.security_demo.entity.Customer;
import com.security.security_demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(@Qualifier("customerServiceImpl") CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public String createAccount(@RequestBody Customer customer) {
        return customerService.createAccount(customer);
    }
}
