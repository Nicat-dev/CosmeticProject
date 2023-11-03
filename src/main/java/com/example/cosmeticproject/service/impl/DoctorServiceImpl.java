package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.DoctorDto;
import com.example.cosmeticproject.dto.request.DoctorRequest;
import com.example.cosmeticproject.entity.Doctors;
import com.example.cosmeticproject.exception.ResourceNotFoundException;
import com.example.cosmeticproject.mapper.DoctorMapper;
import com.example.cosmeticproject.repository.DoctorRepository;
import com.example.cosmeticproject.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    final DoctorRepository doctorRepository;
    final DoctorMapper mapper;

    @Override
    public DoctorDto getDoctorById(Long id) {
        return mapper.entityToDto(doctorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("id",id.toString(),id)));
    }

    @Override
    public List<DoctorDto> getDoctors() {
        List<Doctors> doctors = doctorRepository.findAll();
        return mapper.listOfDoctros(doctors);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(doctorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("id",id.toString(),id)).getId());
    }

    @Override
    public void saveDoctor(DoctorRequest doctorRequest) {
        doctorRepository.save(mapper.requestToEntity(doctorRequest));
    }
}
