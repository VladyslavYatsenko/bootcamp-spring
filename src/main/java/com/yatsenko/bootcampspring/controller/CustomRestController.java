package com.yatsenko.bootcampspring.controller;

import com.yatsenko.bootcampspring.model.Customer;
import com.yatsenko.bootcampspring.service.CustomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@AllArgsConstructor
public class CustomRestController {

    private final CustomService customService;

    @GetMapping("/customers")
    public Collection<Customer> getCustomers() {
        return customService.findAll();
    }
}
