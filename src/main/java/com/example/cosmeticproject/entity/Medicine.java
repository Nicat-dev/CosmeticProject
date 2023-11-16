package com.example.cosmeticproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "medicine")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "medicine_name", nullable = false)
    private String medicineName;
    @Column(name = "medicine_country")
    private String medicineCountry;
    @Column(name = "count")
    private Long count;
    @Column(name = "price")
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Medicine medicine = (Medicine) o;
        return id != null && Objects.equals(id, medicine.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
