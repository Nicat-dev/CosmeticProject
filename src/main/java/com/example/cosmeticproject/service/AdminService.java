package com.example.cosmeticproject.service;

import com.example.cosmeticproject.dto.AdminstartionDto;
import com.example.cosmeticproject.dto.request.AdminstrationRequest;

public interface AdminService {

    AdminstartionDto getAdminByEmail(String email);
    AdminstartionDto getAdminByUsername(String userName);
    AdminstartionDto getAdminById(Long id);
    void updateAdmin(AdminstrationRequest adminstrationRequest);
    void saveAdmin(AdminstrationRequest adminstrationRequest);
    void deleteById(Long id);
    void deleteByEmail(String email);
    void deleteByUserName(String username);
}
