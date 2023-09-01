package com.example.cosmeticproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "medicine")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "medicine_name",nullable = false)
    private String medicineName;
    @Column(name = "medicine_country")
    private String medicineCountry;
    @Column(name = "count")
    private Long count;
    @Column(name = "price")
    private BigDecimal price;
}
