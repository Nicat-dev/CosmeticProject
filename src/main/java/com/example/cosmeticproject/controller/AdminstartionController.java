package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.AdminstartionDto;
import com.example.cosmeticproject.dto.request.AdminstrationRequest;
import com.example.cosmeticproject.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/admin")
public class AdminstartionController {

    final AdminService service;

    @PostMapping("/save")
    public ResponseEntity<AdminstartionDto> save(@RequestBody AdminstrationRequest request){
        final var dto = service.saveAdmin(request);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}").build(dto.getId());
        return ResponseEntity.created(location).body(dto);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<AdminstartionDto> getAdminById(@PathVariable Long id){
        final var dto = service.getAdminById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<AdminstartionDto> getAdminByEmail(@PathVariable String email){
        final var dto = service.getAdminByEmail(email);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/getAdminByName/{username}")
    public ResponseEntity<AdminstartionDto> getAdminByUsername(@PathVariable String username){
        final var dto = service.getAdminByUsername(username);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AdminstartionDto> updateAdmin(@RequestBody AdminstrationRequest request,
                                                                      @PathVariable Long id){
        final var dto = service.updateAdmin(request,id);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}").build(dto.getId());

        return ResponseEntity.created(location).body(dto);
    }



}
