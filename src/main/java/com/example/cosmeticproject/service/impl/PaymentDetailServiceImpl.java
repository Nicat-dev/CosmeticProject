package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.PaymentDetailDto;
import com.example.cosmeticproject.dto.request.PaymentDetailRequest;
import com.example.cosmeticproject.entity.PaymentDetail;
import com.example.cosmeticproject.exception.ResourceNotFoundException;
import com.example.cosmeticproject.mapper.PaymentDetailMapper;
import com.example.cosmeticproject.repository.PaymentRepository;
import com.example.cosmeticproject.service.PaymentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PaymentDetailServiceImpl implements PaymentDetailService {

    PaymentRepository repository;
    PaymentDetailMapper paymentDetailMapper;

    @Override
    public PaymentDetailDto getById(Long id) {
        return paymentDetailMapper.entityToDto(findById(id));
    }

    @Override
    public PaymentDetailDto savePaymentDetail(PaymentDetailRequest request) {
       return paymentDetailMapper.entityToDto(repository.save(requestToEntity(request)));
    }

    @Override
    public PaymentDetailDto updatePaymentDetail(PaymentDetailRequest request,Long id) {
       return paymentDetailMapper.entityToDto(requestToEntity(request,id));
    }

    @Override
    public List<PaymentDetailDto> getAllPayment() {

        List<PaymentDetail> paymentDetails = repository.findAll();
        return paymentDetailMapper.entityListToDtoList(paymentDetails);
    }

    @Override
    public void deleteById(Long id) {
        repository.delete(findById(id));
    }

    private PaymentDetail findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("id","id",id));
    }

    private PaymentDetail requestToEntity(PaymentDetailRequest request){
        return paymentDetailMapper.requestToEntity(request);
    }

    private PaymentDetail requestToEntity(PaymentDetailRequest request,Long id){
        if (Objects.isNull(id)){
            throw new ResourceNotFoundException(request.getPaymentInfo(),request.getPaymentInfo(),request.getId());
        }else{
            return paymentDetailMapper.requestToEntity(request);
        }
    }
}
