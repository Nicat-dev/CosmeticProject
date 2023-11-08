package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.DoctorDto;
import com.example.cosmeticproject.dto.request.DoctorRequest;
import com.example.cosmeticproject.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctor")
@RequiredArgsConstructor
public class DoctorController {

    final DoctorService doctorService;

    @GetMapping("/getAll")
    public List<DoctorDto> getAllDoctor(){
        return doctorService.getDoctors();
    }

    @PostMapping("/addDoctor")
    public void addDoctor(@RequestBody DoctorRequest doctorRequest){
        doctorService.saveDoctor(doctorRequest);
    }

    @GetMapping("/findById/{id}")
    public DoctorDto getById(@PathVariable Long id){
        return doctorService.getDoctorById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        doctorService.deleteDoctorById(id);
    }


}
