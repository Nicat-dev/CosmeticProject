package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.MedicineDto;
import com.example.cosmeticproject.dto.request.MedicineRequest;
import com.example.cosmeticproject.entity.Medicine;
import com.example.cosmeticproject.exception.ResourceIdCanNotBeNull;
import com.example.cosmeticproject.mapper.MedicineMapper;
import com.example.cosmeticproject.repository.MedicineRepository;
import com.example.cosmeticproject.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.example.cosmeticproject.constants.ConstantValue.NOT_STOCK;

@Service
@RequiredArgsConstructor
public class MedicalServiceImpl implements MedicineService {

    final MedicineRepository repository;
    final MedicineMapper mapper;

    @Override
    public void addMedicine(MedicineRequest request) {
        if (Objects.isNull(request)){
            throw new RuntimeException("request cannot be null");
        }else {
            repository.save(mapper.requestToEntity(request));
        }
    }

    @Override
    public void updateMedicine(MedicineRequest medicineRequest) {
        if (Objects.isNull(medicineRequest)){
            throw new RuntimeException("request cannot be null");
        }else {
            if (Objects.isNull(medicineRequest.getId())){
                throw new ResourceIdCanNotBeNull(medicineRequest.toString()
                        ,"id",
                        medicineRequest.getId());
            }
            repository.save(mapper.requestToEntity(medicineRequest));
        }
    }

    @Override
    public MedicineDto getMedicineById(Long id) {
        Optional<Medicine> medicine = repository.findById(id);
        if (medicine.isPresent()){
            throw new RuntimeException("id cannot be null");
        }else {
            return mapper.entityToDto(repository.findById(id).get());
        }

    }

    @Override
    public List<MedicineDto> getMedicineList() {
        List<Medicine> list = repository.findAll();
        List<MedicineDto> dtoList = new ArrayList<>();
        for (Medicine medicine : list) {
            dtoList.add(mapper.entityToDto(medicine));
        }
        return dtoList;
    }

    @Override
    public List<MedicineDto> getMedicineInNotStock() {
        List<Medicine> list = repository.findAllByCount(NOT_STOCK);
        List<MedicineDto> dtoList = new ArrayList<>();
        for (Medicine medicine : list) {
            dtoList.add(mapper.entityToDto(medicine));
        }
        return dtoList;
    }

}
