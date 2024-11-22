package com.security.security_demo.service.implementation;

import com.security.security_demo.entity.Customer;
import com.security.security_demo.repository.CustomerRepository;
import com.security.security_demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public String createAccount(Customer customer) {
        try {
            if(!ObjectUtils.isEmpty(customer)) {
                throw new RuntimeException("Customer details must not be emtpy");
            }

            customerRepository.save(customer);

            return "saved";
        } catch(Exception e) {
            return "failed";
        }
    }
}