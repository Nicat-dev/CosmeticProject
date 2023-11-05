package com.example.cosmeticproject.service;

import com.example.cosmeticproject.dto.CosmeticOrderDto;
import com.example.cosmeticproject.dto.request.CosmeticOrderRequest;

import java.util.List;

public interface CosmeticOrderService {

    CosmeticOrderDto getCustomerById(Long id);
    List<CosmeticOrderDto> getCustomerList();
    CosmeticOrderDto updateCosmeticOrderById(CosmeticOrderRequest request, Long id);
    void deleteById(Long id);
    void saveCosmeticOrder(CosmeticOrderRequest request);


}
