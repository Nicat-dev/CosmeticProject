package com.example.cosmeticproject.service;

import com.example.cosmeticproject.dto.CustomerDto;
import com.example.cosmeticproject.dto.request.CustomerRequest;

import java.util.List;

public interface CustomerService {

    CustomerDto getCustomerById(Long id);
    List<CustomerDto> getAllCustomerByName(String name);
    CustomerDto getCustomerByEmail(String email);
    List<CustomerDto> getCustomersByNameAndSurname(String name,String surname);
    void saveCustomer(CustomerRequest customerRequest);
    void updateCustomer(CustomerRequest customerRequest);
    void deleteCustomerById(Long id);
    void deleteCustomerByEmail(String email);
}
