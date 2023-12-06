package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.PaymentDetailDto;
import com.example.cosmeticproject.dto.request.PaymentDetailRequest;
import com.example.cosmeticproject.service.PaymentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/paymentDetail")
@RequiredArgsConstructor
public class PaymentDetailController {

    private final PaymentDetailService service;


    @GetMapping("/getById/{id}")
    public ResponseEntity<PaymentDetailDto> paymentInfo(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }


    @PostMapping("/save")
    public void savePaymentDetails(@RequestBody PaymentDetailRequest request){
        service.savePaymentDetail(request);
    }
}
