package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.PaymentDetailDto;
import com.example.cosmeticproject.dto.request.PaymentDetailRequest;
import com.example.cosmeticproject.service.PaymentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/payment-details")
@RequiredArgsConstructor
public class PaymentDetailController {

    private final PaymentDetailService service;


    @GetMapping("/{id}")
    public ResponseEntity<PaymentDetailDto> paymentInfo(@PathVariable Long id) {
        final var dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    /*

    /api/v1/users POST, GET
    /api/v1/users/{id}, UPDATE, GET
    /api/v1/users/{id}/change-status?to=ACTIVE PATCH

     */

    @PostMapping
    public ResponseEntity<PaymentDetailDto> savePaymentDetails(@RequestBody PaymentDetailRequest request) {
        final var dto = service.savePaymentDetail(request);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").build(dto.getId());
        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDetailDto> updatePaymentInfo(@Valid @RequestBody PaymentDetailRequest request,
                                                              @PathVariable Long id) {
        final var dto = service.updatePaymentDetail(request,id);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}").build(dto.getId());

        return ResponseEntity.created(location).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<PaymentDetailDto>> getAllPaymentInfo() {
        final var dtoList = service.getAllPayment();
        return ResponseEntity.ok(dtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
