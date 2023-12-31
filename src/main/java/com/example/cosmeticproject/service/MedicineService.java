package com.example.cosmeticproject.service;

import com.example.cosmeticproject.dto.MedicineDto;
import com.example.cosmeticproject.dto.request.MedicineRequest;
import com.example.cosmeticproject.entity.Medicine;

import java.util.List;

public interface MedicineService {

    MedicineDto addMedicine(MedicineRequest request);
    MedicineDto updateMedicine(MedicineRequest medicineRequest,Long id);
    MedicineDto getMedicineById(Long id);
    List<MedicineDto> getMedicineList();
    List<MedicineDto> getMedicineInNotStock();
}
