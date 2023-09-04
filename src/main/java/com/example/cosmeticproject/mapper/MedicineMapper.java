package com.example.cosmeticproject.mapper;

import com.example.cosmeticproject.dto.MedicineDto;
import com.example.cosmeticproject.dto.request.MedicineRequest;
import com.example.cosmeticproject.entity.Medicine;
import org.mapstruct.Mapper;

@Mapper
public interface MedicineMapper {

    Medicine requestToEntity(MedicineRequest request);
    MedicineDto entityToDto(Medicine medicine);

}
