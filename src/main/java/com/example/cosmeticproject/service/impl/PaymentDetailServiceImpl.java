package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.PaymentDetailDto;
import com.example.cosmeticproject.dto.request.PaymentDetailRequest;
import com.example.cosmeticproject.repository.PaymentRepository;
import com.example.cosmeticproject.service.PaymentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentDetailServiceImpl implements PaymentDetailService {

    final PaymentRepository repository;

    @Override
    public PaymentDetailDto findById(Long id) {
        return null;
    }

    @Override
    public void savePaymentDetail(PaymentDetailRequest request) {

    }

    @Override
    public void updatePaymentDetail(PaymentDetailRequest request) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
