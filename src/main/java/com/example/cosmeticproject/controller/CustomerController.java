package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.CustomerDto;
import com.example.cosmeticproject.dto.response.BaseResponse;
import com.example.cosmeticproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/customer")
@RequiredArgsConstructor
public class CustomerController {

    final CustomerService customerService;

    @RequestMapping("/getCustomerById/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id){
        final var dto = customerService.getCustomerById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/getAllCustomerByName/{name}")
    public ResponseEntity<List<CustomerDto>> getAllCustomerByName(@PathVariable String name){
        final var dtoList = customerService.getAllCustomerByName(name);
        return ResponseEntity.ok().body(dtoList);
    }

    }

