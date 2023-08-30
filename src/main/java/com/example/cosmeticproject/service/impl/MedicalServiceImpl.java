package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.MedicineDto;
import com.example.cosmeticproject.dto.request.MedicineRequest;
import com.example.cosmeticproject.entity.Medicine;
import com.example.cosmeticproject.repository.MedicineRepository;
import com.example.cosmeticproject.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.cosmeticproject.constants.ConstantValue.NOT_STOCK;

@Service
@RequiredArgsConstructor
public class MedicalServiceImpl implements MedicineService {

    final MedicineRepository repository;

    @Override
    public void addMedicine(MedicineRequest request) {
         repository.save(requestToEntity(request));
    }

    @Override
    public void updateMedicine(MedicineRequest medicineRequest) {

    }

    @Override
    public MedicineDto getMedicineById(Long id) {
        if (id == null){
            throw new RuntimeException("id cannot be null");
        }else {
            return entityToDto(repository.findById(id).get());
        }

    }

    @Override
    public List<MedicineDto> getMedicineList() {
        List<Medicine> list = repository.findAll();
        List<MedicineDto> dtoList = new ArrayList<>();
        for (Medicine medicine : list) {
            dtoList.add(entityToDto(medicine));
        }
        return dtoList;
    }

    @Override
    public List<MedicineDto> getMedicineInNotStock() {
        List<Medicine> list = repository.findAllByCount(NOT_STOCK);
        List<MedicineDto> dtoList = new ArrayList<>();
        for (Medicine medicine : list) {
            dtoList.add(entityToDto(medicine));
        }
        return dtoList;
    }

    private Medicine requestToEntity(MedicineRequest request){
        return Medicine.builder()
                .count(request.getCount())
                .medicineCountry(request.getMedicineCountry())
                .medicineName(request.getMedicineName())
                .price(request.getPrice())
                .build();
    }

    private MedicineDto entityToDto(Medicine medicine){
        return MedicineDto.builder()
                .count(medicine.getCount())
                .medicineCountry(medicine.getMedicineCountry())
                .medicineName(medicine.getMedicineName())
                .price(medicine.getPrice())
                .build();

    }

}
