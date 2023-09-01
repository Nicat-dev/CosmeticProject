package com.example.cosmeticproject.service;

import com.example.cosmeticproject.dto.PaymentDetailDto;
import com.example.cosmeticproject.dto.request.PaymentDetailRequest;

public interface PaymentDetailService {

    PaymentDetailDto findById(Long id);
    void savePaymentDetail(PaymentDetailRequest request);
    void updatePaymentDetail(PaymentDetailRequest request);
    void deleteById(Long id);
}
