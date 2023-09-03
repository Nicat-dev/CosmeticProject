package com.example.cosmeticproject.mapper;

import com.example.cosmeticproject.dto.PaymentDetailDto;
import com.example.cosmeticproject.dto.request.PaymentDetailRequest;
import com.example.cosmeticproject.entity.PaymentDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentDetailMapper {

    PaymentDetailMapper INSTANCE = Mappers.getMapper(PaymentDetailMapper.class);

    PaymentDetailDto entityToDto(PaymentDetail paymentDetail);
    PaymentDetail requestToEntity(PaymentDetailRequest request);
}
