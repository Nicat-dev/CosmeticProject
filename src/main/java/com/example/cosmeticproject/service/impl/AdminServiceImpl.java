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


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    AdminRepository adminRepository;
    AdminMapper adminMapper;

    @Override
    public AdminstartionDto getAdminByEmail(String email) {
        Adminstration adminstration = adminRepository.findByEmail(email);
        return adminMapper.entityToDto(adminstration);
    }

    @Override
    public AdminstartionDto getAdminByUsername(String userName) {
        Adminstration adminstration = adminRepository.findByUsername(userName);
        return adminMapper.entityToDto(adminstration);
    }

    @Override
    public AdminstartionDto getAdminById(Long id) {
        return adminMapper.entityToDto(adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin","id",id)));
    }

    @Override
    public AdminstartionDto updateAdmin(AdminstrationRequest adminstrationRequest,Long id) {
        return adminMapper.entityToDto(adminRepository.save(adminRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("admin",id.toString(),adminstrationRequest))));

    }

    @Override
    public AdminstartionDto saveAdmin(AdminstrationRequest adminstrationRequest) {
        return adminMapper.entityToDto(adminRepository.save(adminMapper.requestToEntity(adminstrationRequest)));
    }

    @Override
    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }

}
