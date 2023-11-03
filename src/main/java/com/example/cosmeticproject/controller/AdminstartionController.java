package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.AdminstartionDto;
import com.example.cosmeticproject.dto.request.AdminstrationRequest;
import com.example.cosmeticproject.dto.response.BaseResponse;
import com.example.cosmeticproject.entity.Adminstration;
import com.example.cosmeticproject.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.lang.Boolean.TRUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminstartionController {

    final AdminService service;

    @PostMapping("/save")
    public ResponseEntity<BaseResponse<Adminstration>> save(@RequestBody AdminstrationRequest request){
        return ResponseEntity.ok(new BaseResponse<>(TRUE,
                "Admin succesfully added",
                service.saveAdmin(request)));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<BaseResponse<AdminstartionDto>> getAdminById(@PathVariable Long id){
        return ResponseEntity.ok(new BaseResponse<>(TRUE,
                "Admin succesfully finded",
                service.getAdminById(id)));
    }

    @GetMapping("/getAdminByName/{username}")
    public ResponseEntity<BaseResponse<AdminstartionDto>> getAdminByUsername(@PathVariable String username){
        return ResponseEntity.ok(new BaseResponse<>(TRUE,
                "Admin successfully finded",
                service.getAdminByUsername(username)));
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BaseResponse<AdminstartionDto>> updateAdmin(@RequestBody AdminstrationRequest request,
                                                                      @PathVariable Long id){
        return ResponseEntity.ok(new BaseResponse<>(TRUE,
                "Admin succesfully updated",
                service.updateAdmin(request,id)));
    }



}
