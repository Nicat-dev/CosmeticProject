package com.example.cosmeticproject.entity;

import com.example.cosmeticproject.enums.Position;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "doctors")
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NotBlank(message = "doctor's name cannot be blank")
    private String name;
    @Column(name = "surname")
    @NotBlank(message = "doctor's surname cannot be blank")
    private String surname;
    @Column(name = "email")
    @NotBlank(message = "doctor's email cannot be blank")
    private String email;
    @Column(name = "position")
    @NotBlank(message = "doctor's position cannot be blank")
    private Position position;
    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false,updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "doctors", orphanRemoval = true)
    private List<Customer> customers = new ArrayList<>();

}
