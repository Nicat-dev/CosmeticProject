package com.example.cosmeticproject.repository;

import com.example.cosmeticproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findCustomerById(Long id);
    List<Customer> findAllByName(String name);
    Customer findCustomerByEmail(String email);
    List<Customer> findAllByNameAndSurname(String name, String surname);

}
