package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.request.CustomerRequest;
import com.example.cosmeticproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    final CustomerService customerService;

    @PostMapping(value = "/save")
    public void saveCustomer(@RequestBody CustomerRequest customerRequest){
        customerService.saveCustomer(customerRequest);
    }
}
