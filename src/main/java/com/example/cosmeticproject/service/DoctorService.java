package com.example.cosmeticproject.service;

import com.example.cosmeticproject.dto.DoctorDto;
import com.example.cosmeticproject.dto.request.DoctorRequest;

import java.util.List;

public interface DoctorService {

    DoctorDto getDoctorById(Long id);
    List<DoctorDto> getDoctors();
    void deleteDoctorById(Long id);
    void saveDoctor(DoctorRequest doctorRequest);
}
