package com.security.security_demo.service;

import com.security.security_demo.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    public String createAccount(Customer customer);
}
