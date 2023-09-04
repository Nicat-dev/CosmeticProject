package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.PaymentDetailDto;
import com.example.cosmeticproject.dto.request.PaymentDetailRequest;
import com.example.cosmeticproject.exception.ResourceExistsException;
import com.example.cosmeticproject.exception.ResourceNotFoundException;
import com.example.cosmeticproject.mapper.PaymentDetailMapper;
import com.example.cosmeticproject.repository.PaymentRepository;
import com.example.cosmeticproject.service.PaymentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PaymentDetailServiceImpl implements PaymentDetailService {

    final PaymentRepository repository;
    final PaymentDetailMapper paymentDetailMapper;

    @Override
    public PaymentDetailDto findById(Long id) {
        return paymentDetailMapper.entityToDto(
                repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("id","id",id)));
    }

    @Override
    public void savePaymentDetail(PaymentDetailRequest request) {
        if (Objects.nonNull(request.getId())) {
            throw new ResourceExistsException(
                    request.getPaymentInfo(),
                    request.getPaymentInfo(),
                    request);
        }else {
            repository.save(paymentDetailMapper.requestToEntity(request));
        }
    }

    @Override
    public void updatePaymentDetail(PaymentDetailRequest request) {
        if (Objects.isNull(request.getId())) {
            throw new ResourceNotFoundException(
                    request.getPaymentInfo(),
                    request.getPaymentInfo(),
                    request);
        }else {
            repository.save(paymentDetailMapper.requestToEntity(request));
        }
    }

    @Override
    public void deleteById(Long id) {
        if (Objects.isNull(id)){
            throw new ResourceNotFoundException("Id can not find","id",id);
        }else {
            repository.deleteById(id);
        }
    }
}
