package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.AdminstartionDto;
import com.example.cosmeticproject.dto.request.AdminstrationRequest;
import com.example.cosmeticproject.entity.Adminstration;
import com.example.cosmeticproject.exception.ResourceNotFoundException;
import com.example.cosmeticproject.mapper.AdminMapper;
import com.example.cosmeticproject.repository.AdminRepository;
import com.example.cosmeticproject.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    final AdminRepository adminRepository;
    final AdminMapper mapper;

    @Override
    public AdminstartionDto getAdminByEmail(String email) {
        Adminstration adminstration = adminRepository.findByEmail(email);
        return mapper.entityToDto(adminstration);
    }

    @Override
    public AdminstartionDto getAdminByUsername(String userName) {
        Adminstration adminstration = adminRepository.findByUsername(userName);
        return mapper.entityToDto(adminstration);
    }

    @Override
    public AdminstartionDto getAdminById(Long id) {
        return mapper.entityToDto(adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin","id",id)));
    }

    @Override
    public AdminstartionDto updateAdmin(AdminstrationRequest adminstrationRequest,Long id) {
        Adminstration adminstration = adminRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("admin",id.toString(),adminstrationRequest));
        return mapper.entityToDto(adminRepository.save(adminstration));

    }

    @Override
    public Adminstration saveAdmin(AdminstrationRequest adminstrationRequest) {
        return adminRepository.save(mapper.requetsToEntity(adminstrationRequest));
    }

    @Override
    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }

}
