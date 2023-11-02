package com.example.cosmeticproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerReceiptRequest {
    private Long id;
    private String illness;
    private String medicine;
    private String term;
}
