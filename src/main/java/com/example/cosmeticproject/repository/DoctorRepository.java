package com.example.cosmeticproject.repository;

import com.example.cosmeticproject.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctors,Long> {


}
