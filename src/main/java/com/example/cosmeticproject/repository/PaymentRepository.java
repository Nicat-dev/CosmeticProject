package com.example.cosmeticproject.repository;

import com.example.cosmeticproject.entity.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentDetail,Long> {
}
