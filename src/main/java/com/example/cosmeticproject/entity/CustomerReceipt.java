package com.example.cosmeticproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_receipt")
public class CustomerReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "illness",nullable = false)
    private String illness;
    @Column(name = "medicine")
    private String medicine;
    @Column(name = "term")
    private Long term;
}
