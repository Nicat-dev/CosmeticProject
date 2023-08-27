package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.DoctorDto;
import com.example.cosmeticproject.dto.request.DoctorRequest;
import com.example.cosmeticproject.entity.Doctors;
import com.example.cosmeticproject.repository.DoctorRepository;
import com.example.cosmeticproject.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    final DoctorRepository doctorRepository;

    @Override
    public DoctorDto getDoctorById(Long id) {
        Optional<Doctors> doctors = doctorRepository.findById(id);
        return doctors.map(this::entityToDto).orElse(null);
    }

    @Override
    public List<DoctorDto> getDoctors() {
        List<Doctors> doctors = doctorRepository.findAll();
        List<DoctorDto> doctorDtos = new ArrayList<>();
        for (Doctors doctor : doctors) {
            doctorDtos.add(entityToDto(doctor));
        }
        return doctorDtos;
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public void saveDoctor(DoctorRequest doctorRequest) {
        doctorRepository.save(requestToEntity(doctorRequest));
    }

    private DoctorDto entityToDto(Doctors entity){
        return DoctorDto.builder()
                .name(entity.getName())
                .surname(entity.getSurname())
                .email(entity.getEmail())
                .position(entity.getPosition().getDisplayValue())
                .description(entity.getDescription())
                .build();
    }

    private Doctors requestToEntity(DoctorRequest doctorRequest){
        return Doctors.builder()
                .name(doctorRequest.getName())
                .surname(doctorRequest.getSurname())
                .email(doctorRequest.getEmail())
                .position(doctorRequest.getPosition())
                .description(doctorRequest.getDescription())
                .build();
    }
}
