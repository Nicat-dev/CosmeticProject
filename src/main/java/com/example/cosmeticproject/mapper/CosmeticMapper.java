package com.example.cosmeticproject.mapper;

import com.example.cosmeticproject.dto.CosmeticOrderDto;
import com.example.cosmeticproject.dto.request.CosmeticOrderRequest;
import com.example.cosmeticproject.entity.CosmeticOrder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CosmeticMapper {

    CosmeticOrderDto entityToDto(CosmeticOrder order);
    CosmeticOrder requestToEntity(CosmeticOrderRequest request);
    List<CosmeticOrderDto> dtoList(List<CosmeticOrder> list);

}
