package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.PaymentDetailDto;
import com.example.cosmeticproject.dto.request.PaymentDetailRequest;
import com.example.cosmeticproject.service.PaymentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/update/{id}")
    public ResponseEntity<PaymentDetailDto> updatePaymentInfo(@RequestBody PaymentDetailRequest request,
                                                              @PathVariable Long id){
        return ResponseEntity.ok(service.updatePaymentDetail(request,id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PaymentDetailDto>> getAllPaymentInfo(){
        return ResponseEntity.ok(service.getAllPayment());
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

}
