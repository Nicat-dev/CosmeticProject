package com.example.cosmeticproject.mapper;

import com.example.cosmeticproject.dto.AdminstartionDto;
import com.example.cosmeticproject.entity.Adminstration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    AdminstartionDto entityToDto(Adminstration adminstration);

}
