package com.security.security_demo.repository;

import com.security.security_demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    @Query(nativeQuery = true, value = "select * from customer where email = :email")
    Optional<Customer> findByEmail(@Param("email") String email);
}