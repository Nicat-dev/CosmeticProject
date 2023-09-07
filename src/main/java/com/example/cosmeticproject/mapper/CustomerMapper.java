package com.example.cosmeticproject.mapper;

import com.example.cosmeticproject.dto.CustomerDto;
import com.example.cosmeticproject.dto.request.CustomerRequest;
import com.example.cosmeticproject.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    CustomerDto entityToDto(Customer customer);
    Customer requestToEntity(CustomerRequest request);
    List<CustomerDto> customerDtoList(List<Customer> customers);

}
