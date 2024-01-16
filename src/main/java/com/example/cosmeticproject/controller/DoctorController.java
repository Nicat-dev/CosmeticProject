package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.DoctorDto;
import com.example.cosmeticproject.dto.request.DoctorRequest;
import com.example.cosmeticproject.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/doctor")
@RequiredArgsConstructor
public class DoctorController {

    final DoctorService doctorService;

    @GetMapping("/getAll")
    public ResponseEntity<List<DoctorDto>> getAllDoctor(){
        final var dto = doctorService.getDoctors();
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/addDoctor")
    public ResponseEntity<DoctorDto> addDoctor(@RequestBody DoctorRequest doctorRequest){
        final var dto = doctorService.saveDoctor(doctorRequest);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}").build(dto);
        return ResponseEntity.created(location).body(dto);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<DoctorDto> getById(@PathVariable Long id){
        final var dto = doctorService.getDoctorById(id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        doctorService.deleteDoctorById(id);
        return ResponseEntity.noContent().build();
    }


}
