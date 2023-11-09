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
    public ResponseEntity<BaseResponse<CustomerDto>> getCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE,
                "Customer successffully find",
                customerService.getCustomerById(id)));
    }

    @GetMapping("/getAllCustomerByName/{name}")
    public ResponseEntity<BaseResponse<List<CustomerDto>>> getAllCustomerByName(@PathVariable String name){

        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE,
                "CustomerList succesfully find",
                customerService.getAllCustomerByName(name)));
    }

    }

