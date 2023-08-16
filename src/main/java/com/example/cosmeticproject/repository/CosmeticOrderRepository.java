package com.example.cosmeticproject.repository;

import com.example.cosmeticproject.entity.CosmeticOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CosmeticOrderRepository extends JpaRepository<CosmeticOrder,Long> {
}
