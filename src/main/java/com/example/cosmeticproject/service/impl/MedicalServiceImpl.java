package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.MedicineDto;
import com.example.cosmeticproject.dto.request.MedicineRequest;
import com.example.cosmeticproject.entity.Doctors;
import com.example.cosmeticproject.entity.Medicine;
import com.example.cosmeticproject.exception.ResourceIdCanNotBeNull;
import com.example.cosmeticproject.exception.ResourceNotFoundException;
import com.example.cosmeticproject.mapper.MedicineMapper;
import com.example.cosmeticproject.repository.MedicineRepository;
import com.example.cosmeticproject.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.example.cosmeticproject.constants.ConstantValue.NOT_STOCK;

@Service
@RequiredArgsConstructor
public class MedicalServiceImpl implements MedicineService {

    MedicineRepository repository;
    MedicineMapper mapper;

    @Override
    public MedicineDto addMedicine(MedicineRequest request) {
        if (Objects.isNull(request)){
            throw new RuntimeException("request cannot be null");
        }else {
            return mapper.entityToDto(repository.save(mapper.requestToEntity(request)));
        }
    }

    @Override
    public MedicineDto updateMedicine(MedicineRequest medicineRequest,Long id) {
        findMedicineById(id);
        return mapper.entityToDto(repository.save(mapper.requestToEntity(medicineRequest)));
    }

    @Override
    public MedicineDto getMedicineById(Long id) {
            return mapper.entityToDto(findMedicineById(id));

    }

    @Override
    public List<MedicineDto> getMedicineList() {
        return mapper.medicineDtoList(repository.findAll());
    }

    @Override
    public List<MedicineDto> getMedicineInNotStock() {
        return mapper.medicineDtoList(repository.findAllByCount(NOT_STOCK));
    }

    private Medicine findMedicineById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Medcine","id",id));
    }

}
