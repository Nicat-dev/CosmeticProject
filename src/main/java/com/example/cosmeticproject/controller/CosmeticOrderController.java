package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.CosmeticOrderDto;
import com.example.cosmeticproject.dto.request.CosmeticOrderRequest;
import com.example.cosmeticproject.dto.response.BaseResponse;
import com.example.cosmeticproject.service.CosmeticOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Boolean.TRUE;

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
    public ResponseEntity<BaseResponse<CosmeticOrderDto>> getCosmeticOrderById(@PathVariable Long id){
        return ResponseEntity.ok(new BaseResponse<>(TRUE,
                "Customer successfully find"
                , service.getCustomerById(id)));
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @GetMapping("/getAllCosmetic")
    public ResponseEntity<BaseResponse<List<CosmeticOrderDto>>> getCosmeticList(){
        return ResponseEntity.ok(new BaseResponse<>(TRUE,
                "Customer List Successfully finded"
                ,service.getCustomerList()));
    }

}
