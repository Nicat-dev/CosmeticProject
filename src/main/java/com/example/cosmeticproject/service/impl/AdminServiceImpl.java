package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.AdminstartionDto;
import com.example.cosmeticproject.dto.request.AdminstrationRequest;
import com.example.cosmeticproject.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public AdminstartionDto getAdminByEmail(String email) {
        return null;
    }

    @Override
    public AdminstartionDto getAdminByUsername(String userName) {
        return null;
    }

    @Override
    public AdminstartionDto getAdminById(Long id) {
        return null;
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
}
