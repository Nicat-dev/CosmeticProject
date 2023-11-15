package com.example.cosmeticproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;

@Entity

@DynamicInsert
@DynamicUpdate
@Table(name = "payment_detail")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "payment_info")
    private String paymentInfo;
    private BigDecimal paymentCost;
    private BigDecimal salePercentage;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
