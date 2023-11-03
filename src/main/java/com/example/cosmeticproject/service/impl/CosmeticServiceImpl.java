package com.example.cosmeticproject.service.impl;

import com.example.cosmeticproject.dto.CosmeticOrderDto;
import com.example.cosmeticproject.dto.request.CosmeticOrderRequest;
import com.example.cosmeticproject.entity.CosmeticOrder;
import com.example.cosmeticproject.exception.ResourceIdCanNotBeNull;
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

    final CosmeticOrderRepository repository;
    final CosmeticMapper mapper;

    @Override
    public CosmeticOrderDto getCustomerById(Long id) {
        return mapper.entityToDto(repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("CosmeticOrder","CosmeticOrder",id)));
    }

    @Override
    public List<CosmeticOrderDto> getCustomerList() {
        return mapper.dtoList(repository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        CosmeticOrder order = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("CosmeticOrder","id",id));
        repository.deleteById(order.getId());

    }

    @Override
    public void saveCosmeticOrder(CosmeticOrderRequest request) {
        repository.save(mapper.requestToEntity(request));
    }
}
