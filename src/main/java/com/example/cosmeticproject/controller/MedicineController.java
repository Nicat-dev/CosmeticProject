package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.MedicineDto;
import com.example.cosmeticproject.dto.request.MedicineRequest;
import com.example.cosmeticproject.dto.response.BaseResponse;
import com.example.cosmeticproject.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.lang.Boolean.TRUE;

@RestController
@RequestMapping("api/medical")
@RequiredArgsConstructor
public class MedicineController {

    private final MedicineService service;

    @GetMapping("/getAll")
    public ResponseEntity<BaseResponse<List<MedicineDto>>> getAllMedicine(){
        List<MedicineDto> medicineDto = service.getMedicineList();
        return ResponseEntity.ok(new BaseResponse<>(TRUE,
                "Medicine Successfully founded",medicineDto));
    }

    @GetMapping("getAllIsNotStock")
    public ResponseEntity<BaseResponse<List<MedicineDto>>> getMedicineIsNotStock(){
        List<MedicineDto> medicineDtos = service.getMedicineInNotStock();
        return ResponseEntity.ok(new BaseResponse<>(TRUE,
                "Medicine is Not Stock List Successfully founded",medicineDtos));
    }

    @PutMapping("/updateMedicine/{id}")
    public ResponseEntity<BaseResponse<MedicineDto>> updateMedicine(@RequestBody @Valid MedicineRequest request
            ,@PathVariable Long id){
        MedicineDto medicineDto = service.updateMedicine(request,id);
        return ResponseEntity.ok(new BaseResponse<>(TRUE,
                "Medicine successfully updated",medicineDto));
    }

    @PostMapping("/save")
    public ResponseEntity<BaseResponse<MedicineRequest>> saveMedicine(@RequestBody MedicineRequest request){
        return ResponseEntity.ok(new BaseResponse<>(TRUE,"Medicine Succefully added",request));
    }


}
