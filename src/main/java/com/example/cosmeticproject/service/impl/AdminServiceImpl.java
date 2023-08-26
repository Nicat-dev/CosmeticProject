package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.AdminstartionDto;
import com.example.cosmeticproject.dto.request.AdminstrationRequest;
import com.example.cosmeticproject.entity.Adminstration;
import com.example.cosmeticproject.repository.AdminRepository;
import com.example.cosmeticproject.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    final AdminRepository adminRepository;

    @Override
    public AdminstartionDto getAdminByEmail(String email) {
        Adminstration adminstration = adminRepository.findByEmail(email);
        return entityToDto(adminstration);
    }

    @Override
    public AdminstartionDto getAdminByUsername(String userName) {
        Adminstration adminstration = adminRepository.findByUsername(userName);
        return entityToDto(adminstration);
    }

    @Override
    public AdminstartionDto getAdminById(Long id) {
        Optional<Adminstration> adminstration = adminRepository.findById(id);
        return adminstration.map(this::entityToDto).orElse(null);
    }

    @Override
    public void updateAdmin(AdminstrationRequest adminstrationRequest) {

    }

    @Override
    public void saveAdmin(AdminstrationRequest adminstrationRequest) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteByEmail(String email) {

    }

    @Override
    public void deleteByUserName(String username) {

    }

    private AdminstartionDto entityToDto(Adminstration adminstration){
        return AdminstartionDto.builder()
                .name(adminstration.getName())
                .surname(adminstration.getSurname())
                .fatherName(adminstration.getFatherName())
                .motherName(adminstration.getMotherName())
                .gender(String.valueOf(adminstration.getGender()))
                .maritalStatus(String.valueOf(adminstration.getMaritalStatus()))
                .gmail(adminstration.getEmail())
                .position(adminstration.getPosition())
                .location(adminstration.getLocation())
                .build();
    }
}
