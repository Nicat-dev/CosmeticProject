package com.example.cosmeticproject.service;

import com.example.cosmeticproject.dto.AdminstartionDto;
import com.example.cosmeticproject.dto.request.AdminstrationRequest;
import com.example.cosmeticproject.entity.Adminstration;

public interface AdminService {

    AdminstartionDto getAdminByEmail(String email);
    AdminstartionDto getAdminByUsername(String userName);
    AdminstartionDto getAdminById(Long id);
    AdminstartionDto updateAdmin(AdminstrationRequest adminstrationRequest,Long id);
    AdminstartionDto saveAdmin(AdminstrationRequest adminstrationRequest);
    void deleteById(Long id);
}
