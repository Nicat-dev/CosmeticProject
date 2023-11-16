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
public class PaymentDetailRequest {

    private Long id;
    private String paymentInfo;
    private BigDecimal paymentCost;
    private BigDecimal salePercentage;
    private String doctorName;
    private String administratorId;
    private Long customerId;
}
