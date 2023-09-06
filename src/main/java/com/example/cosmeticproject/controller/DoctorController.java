package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.DoctorDto;
import com.example.cosmeticproject.dto.request.DoctorRequest;
import com.example.cosmeticproject.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
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

}
