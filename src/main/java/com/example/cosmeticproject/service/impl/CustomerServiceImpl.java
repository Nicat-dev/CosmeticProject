package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.CustomerDto;
import com.example.cosmeticproject.dto.request.CustomerRequest;
import com.example.cosmeticproject.entity.Customer;
import com.example.cosmeticproject.repository.CustomerRepository;
import com.example.cosmeticproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    final CustomerRepository customerRepository;

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findCustomerById(id);
        return entityToDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomerByName(String name) {
        List<Customer> customers = customerRepository.findAllByName(name);
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDto customerDto = entityToDto(customer);
            customerDtos.add(customerDto);
        }
        return customerDtos;
    }

    @Override
    public CustomerDto getCustomerByEmail(String email) {
        Customer customer = customerRepository.findCustomerByEmail(email);
        return entityToDto(customer);
    }

    @Override
    public List<CustomerDto> getCustomersByNameAndSurname(String name, String surname) {
        List<Customer> customers = customerRepository.findAllByNameAndSurname(name,surname);
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDto customerDto = entityToDto(customer);
            customerDtos.add(customerDto);
        }
        return customerDtos;
    }

    @Override
    public void saveCustomer(CustomerRequest customerRequest) {
        Customer customer = requestToEntity(customerRequest);
        customerRepository.save(customer);

    }

    @Override
    public void updateCustomer(CustomerRequest customerRequest) {
        Customer customer = requestToEntity(customerRequest);
        customer.setId(customerRequest.getId());
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        if (getCustomerById(id) == null){
            throw new RuntimeException("Id tapilmadi");
        }else {
            customerRepository.deleteById(id);
        }
    }

    @Override
    public void deleteCustomerByEmail(String email) {
        if (getCustomerByEmail(email) == null){
            throw new RuntimeException("Email tapilmadi");
        }else {
            customerRepository.deleteByEmail(email);
        }

    }

    private CustomerDto entityToDto(Customer customer){
        return CustomerDto.builder()
                .name(customer.getName())
                .surname(customer.getSurname())
                .fatherName(customer.getFatherName())
                .motherName(customer.getMotherName())
                .phoneNumber(customer.getPhoneNumber())
                .gender(String.valueOf(customer.getGender()))
                .maritalStatus(String.valueOf(customer.getMaritalStatus()))
                .location(customer.getLocation())
                .birthDate(String.valueOf(customer.getBirthDate()))
                .gmail(customer.getEmail())
                .finCode(customer.getFinCode())
                .workLocation(customer.getWorkLocation())
                .build();
    }

    private Customer requestToEntity(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .surname(customerRequest.getSurname())
                .birthDate(customerRequest.getBirthDate())
                .fatherName(customerRequest.getFatherName())
                .motherName(customerRequest.getMotherName())
                .workLocation(customerRequest.getWorkLocation())
                .gender(customerRequest.getGender())
                .maritalStatus(customerRequest.getMaritalStatus())
                .location(customerRequest.getLocation())
                .email(customerRequest.getGmail())
                .phoneNumber(customerRequest.getPhoneNumber())
                .finCode(customerRequest.getFinCode())
                .build();
    }
}
