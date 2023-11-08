package com.example.cosmeticproject.mapper;

import com.example.cosmeticproject.dto.AdminstartionDto;
import com.example.cosmeticproject.dto.request.AdminstrationRequest;
import com.example.cosmeticproject.entity.Adminstration;
import org.mapstruct.Mapper;

@Mapper
public interface AdminMapper {

    Adminstration requestToEntity(AdminstrationRequest request);
    AdminstartionDto entityToDto(Adminstration adminstration);

}
