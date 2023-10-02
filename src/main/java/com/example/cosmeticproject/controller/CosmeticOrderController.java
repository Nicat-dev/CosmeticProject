package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.CosmeticOrderDto;
import com.example.cosmeticproject.dto.request.CosmeticOrderRequest;
import com.example.cosmeticproject.service.CosmeticOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cosmetic")
@RequiredArgsConstructor
public class CosmeticOrderController {

    final CosmeticOrderService service;

    @PostMapping("/save")
    public void saveCosmetic(@RequestBody CosmeticOrderRequest request){
        service.saveCosmeticOrder(request);
    }

    @GetMapping("/getById/{id}")
    public CosmeticOrderDto getCosmeticOrderById(@PathVariable Long id){
        return service.getCustomerById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @GetMapping("/getAllCosmetic")
    public List<CosmeticOrderDto> getCosmeticList(){
        return service.getCustomerList();
    }

}
