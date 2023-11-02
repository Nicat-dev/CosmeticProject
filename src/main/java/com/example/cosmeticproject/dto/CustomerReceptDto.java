package com.example.cosmeticproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerReceptDto {
    private String illness;
    private String medicine;
    private Long term;
}
