package com.yatsenko.bootcampspring.service;

import com.yatsenko.bootcampspring.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CustomService {
    public Collection<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        Stream.of("David", "Artur", "Diana").forEach(c -> customers.add(new Customer(c)));
        return customers;
    }
}
