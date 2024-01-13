package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.CosmeticOrderDto;
import com.example.cosmeticproject.dto.request.CosmeticOrderRequest;
import com.example.cosmeticproject.entity.CosmeticOrder;
import com.example.cosmeticproject.exception.ResourceNotFoundException;
import com.example.cosmeticproject.mapper.CosmeticMapper;
import com.example.cosmeticproject.repository.CosmeticOrderRepository;
import com.example.cosmeticproject.service.CosmeticOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CosmeticServiceImpl implements CosmeticOrderService{

    CosmeticOrderRepository repository;
    CosmeticMapper mapper;

    @Override
    public CosmeticOrderDto getCustomerById(Long id) {
        return mapper.entityToDto(order(id));
    }

    @Override
    public List<CosmeticOrderDto> getCustomerList() {
        return mapper.dtoList(repository.findAll());
    }

    @Override
    public CosmeticOrderDto updateCosmeticOrderById(CosmeticOrderRequest request, Long id) {
        order(id);//check null
        CosmeticOrder cosmeticOrder = mapper.requestToEntity(request);
        return mapper.entityToDto(repository.save(cosmeticOrder));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(order(id).getId());

    }

    @Override
    public CosmeticOrderDto saveCosmeticOrder(CosmeticOrderRequest request) {
        return mapper.entityToDto(repository.save(mapper.requestToEntity(request)));
    }

    private CosmeticOrder order(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("CosmeticOrder","id",id));
    }
}
