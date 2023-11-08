package com.example.cosmeticproject.entity;

import com.example.cosmeticproject.enums.ERole;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role_name",nullable = false)
    private ERole roleName;
}
