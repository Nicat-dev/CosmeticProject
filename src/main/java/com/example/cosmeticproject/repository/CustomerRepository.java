package com.example.cosmeticproject.repository;

import com.example.cosmeticproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findCustomerById(Long id);
    List<Customer> findAllByName(String name);
    Optional<Customer> findCustomerByEmail(String email);
    List<Customer> findAllByNameAndSurname(String name, String surname);
    void deleteByEmail(String email);

}
