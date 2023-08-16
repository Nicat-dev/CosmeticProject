package com.example.cosmeticproject.repository;

import com.example.cosmeticproject.entity.Adminstration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Adminstration,Long> {
    Adminstration findByUsername(String username);
    Adminstration findByEmail(String email);
    List<Adminstration> findAllByName(String name);
}
