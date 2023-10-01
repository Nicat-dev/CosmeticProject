package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.CustomerDto;
import com.example.cosmeticproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CustomerController {

    final CustomerService customerService;

    @RequestMapping("/getCustomerById/{id}")
    public CustomerDto getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    }

