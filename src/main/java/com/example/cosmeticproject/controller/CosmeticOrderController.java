package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.CosmeticOrderDto;
import com.example.cosmeticproject.dto.request.CosmeticOrderRequest;
import com.example.cosmeticproject.service.CosmeticOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("api/cosmetic")
@RequiredArgsConstructor
public class CosmeticOrderController {

    final CosmeticOrderService service;

    @PostMapping("/save")
    public ResponseEntity<CosmeticOrderDto> saveCosmetic(@RequestBody CosmeticOrderRequest request){
        final var dto =service.saveCosmeticOrder(request);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}").build(dto.getId());

        return ResponseEntity.created(location).body(dto);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CosmeticOrderDto> getCosmeticOrderById(@PathVariable Long id){
        final var dto = service.getCustomerById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CosmeticOrderDto> updateCosmeticOrder(@RequestBody CosmeticOrderRequest request,
                                                                @PathVariable Long id){
        final var dto = service.updateCosmeticOrderById(request, id);
        final var location = ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}").build(dto.getId());
        return ResponseEntity.created(location).body(dto);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAllCosmetic")
    public ResponseEntity<List<CosmeticOrderDto>> getCosmeticList(){
        final var dtoList = service.getCustomerList();
        return ResponseEntity.ok().body(dtoList);
    }

}
