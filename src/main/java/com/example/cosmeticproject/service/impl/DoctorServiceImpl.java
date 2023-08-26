package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.DoctorDto;
import com.example.cosmeticproject.dto.request.DoctorRequest;
import com.example.cosmeticproject.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    @Override
    public DoctorDto getDoctorById(Long id) {
        return null;
    }

    @Override
    public List<DoctorDto> getDoctors() {
        return null;
    }

    @Override
    public void deleteDoctorById(Long id) {

    }

    @Override
    public void saveDoctor(DoctorRequest doctorRequest) {

    }
}
