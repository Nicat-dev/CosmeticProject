package com.example.cosmeticproject.service;

import com.example.cosmeticproject.dto.PaymentDetailDto;
import com.example.cosmeticproject.dto.request.PaymentDetailRequest;

import java.util.List;

public interface PaymentDetailService {

    PaymentDetailDto getById(Long id);
    PaymentDetailDto savePaymentDetail(PaymentDetailRequest request);
    PaymentDetailDto updatePaymentDetail(PaymentDetailRequest request,Long id);
    List<PaymentDetailDto> getAllPayment();
    void deleteById(Long id);
}
