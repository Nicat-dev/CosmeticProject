package com.example.cosmeticproject.mapper;

import com.example.cosmeticproject.dto.PaymentDetailDto;
import com.example.cosmeticproject.dto.request.PaymentDetailRequest;
import com.example.cosmeticproject.entity.PaymentDetail;
import org.mapstruct.Mapper;

@Mapper
public interface PaymentDetailMapper {

    PaymentDetailDto entityToDto(PaymentDetail paymentDetail);
    PaymentDetail requestToEntity(PaymentDetailRequest request);
}
