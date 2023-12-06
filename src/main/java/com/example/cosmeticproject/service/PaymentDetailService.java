package com.example.cosmeticproject.service;

import com.example.cosmeticproject.dto.PaymentDetailDto;
import com.example.cosmeticproject.dto.request.PaymentDetailRequest;

import java.util.List;

public interface PaymentDetailService {

    PaymentDetailDto findById(Long id);
    void savePaymentDetail(PaymentDetailRequest request);
    PaymentDetailDto updatePaymentDetail(PaymentDetailRequest request,Long id);
    List<PaymentDetailDto> getAllPayment();
    void deleteById(Long id);
}
