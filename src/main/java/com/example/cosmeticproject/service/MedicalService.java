package com.example.cosmeticproject.service;

import com.example.cosmeticproject.dto.request.MedicineRequest;
import com.example.cosmeticproject.entity.Medicine;

public interface MedicalService {

    Medicine addMedicine(MedicineRequest request);
}
