package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.CustomerDto;
import com.example.cosmeticproject.dto.request.CustomerRequest;
import com.example.cosmeticproject.exception.ResourceNotFoundException;
import com.example.cosmeticproject.mapper.CustomerMapper;
import com.example.cosmeticproject.repository.CustomerRepository;
import com.example.cosmeticproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository customerRepository;
    final CustomerMapper mapper;

    @Override
    public CustomerDto getCustomerById(Long id) {;
        return mapper.entityToDto(customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer" ,"id",id)));
    }

    @Override
    public List<CustomerDto> getAllCustomerByName(String name) {
        return mapper.customerDtoList(customerRepository.findAllByName(name));
    }

    @Override
    public CustomerDto getCustomerByEmail(String email) {
        return mapper.entityToDto(customerRepository.findCustomerByEmail(email));
    }

    @Override
    public List<CustomerDto> getCustomersByNameAndSurname(String name, String surname) {
        return mapper.customerDtoList(customerRepository.findAllByNameAndSurname(name,surname));
    }

    @Override
    public void saveCustomer(CustomerRequest customerRequest) {
        customerRepository.save(mapper.requestToEntity(customerRequest));
    }

    @Override
    public void updateCustomer(CustomerRequest customerRequest) {
        customerRepository.save(mapper
                .requestToEntity(customerRequest));
    }

    @Override
    public void deleteCustomerById(Long id) {
        if (getCustomerById(id) == null){
            throw new ResourceNotFoundException("Customer","Id tapilmadi",id);
        }else {
            customerRepository.deleteById(id);
        }
    }

    @Override
    public void deleteCustomerByEmail(String email) {
        if (getCustomerByEmail(email) == null){
            throw new ResourceNotFoundException("Customer","Email tapilmadi",email);
        }else {
            customerRepository.deleteByEmail(email);
        }

    }
}
