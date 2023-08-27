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
public class MedicineRequest {
    private Long id;
    private String medicineName;
    private String medicineCountry;
    private String count;
    private BigDecimal price;
}
