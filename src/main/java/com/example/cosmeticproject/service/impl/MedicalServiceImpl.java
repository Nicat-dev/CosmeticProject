package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.MedicineDto;
import com.example.cosmeticproject.dto.request.MedicineRequest;
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
    public MedicineDto updateMedicine(MedicineRequest medicineRequest) {
        if (Objects.isNull(medicineRequest)){
            throw new RuntimeException("request cannot be null");
        }else {
            if (Objects.isNull(medicineRequest.getId())){
                throw new ResourceIdCanNotBeNull(medicineRequest.toString()
                        ,"id",
                        medicineRequest.getId());
            }
            Medicine medicine = repository.save(mapper.requestToEntity(medicineRequest));
            return mapper.entityToDto(medicine);
        }
    }

    @Override
    public MedicineDto getMedicineById(Long id) {
            return mapper.entityToDto(repository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Medcine","id",id)));

    }

    @Override
    public List<MedicineDto> getMedicineList() {
        return mapper.medicineDtoList(repository.findAll());
    }

    @Override
    public List<MedicineDto> getMedicineInNotStock() {
        return mapper.medicineDtoList(repository.findAllByCount(NOT_STOCK));
    }

}
