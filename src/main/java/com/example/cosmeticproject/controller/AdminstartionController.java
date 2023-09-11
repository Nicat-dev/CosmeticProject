package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.AdminstartionDto;
import com.example.cosmeticproject.dto.request.AdminstrationRequest;
import com.example.cosmeticproject.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminstartionController {

    final AdminService service;

    @PostMapping("/save")
    public void save(@RequestBody AdminstrationRequest request){
        service.saveAdmin(request);
    }

    @GetMapping("/findById/{id}")
    public AdminstartionDto getAdminById(@PathVariable Long id){
        return service.getAdminById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @PutMapping("/update")
    public void updateAdmin(@RequestBody AdminstrationRequest request){
        service.updateAdmin(request);
    }



}
