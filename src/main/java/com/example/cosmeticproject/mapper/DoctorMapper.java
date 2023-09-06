package com.example.cosmeticproject.mapper;

import com.example.cosmeticproject.dto.DoctorDto;
import com.example.cosmeticproject.dto.request.DoctorRequest;
import com.example.cosmeticproject.entity.Doctors;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DoctorMapper {

    DoctorDto entityToDto(Doctors doctors);
    Doctors requestToEntity(DoctorRequest request);
    List<DoctorDto> listOfDoctros(List<Doctors> doctors);

}
