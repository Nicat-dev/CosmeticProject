package com.example.cosmeticproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CosmeticOrderDto {
    private String orderName;
    private BigDecimal orderValue;
}
