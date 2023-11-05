package com.example.cosmeticproject.repository;

import com.example.cosmeticproject.entity.CustomerReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerReceiptRepository extends JpaRepository<CustomerReceipt,Long> {
}
