package com.example.cosmeticproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CosmeticOrderRequest {
    private Long id;
    private String orderName;
    private BigDecimal orderValue;
}
