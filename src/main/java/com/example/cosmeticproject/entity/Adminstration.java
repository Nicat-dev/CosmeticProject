package com.example.cosmeticproject.entity;

import com.example.cosmeticproject.enums.GenderEnum;
import com.example.cosmeticproject.enums.MaritalStatus;
import com.example.cosmeticproject.enums.Position;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "adminstration")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Adminstration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username",nullable = false,unique = true)
    @NotBlank(message = "username cannot be blank")
    private String username;
    @Column(name = "name",nullable = false)
    @NotBlank(message = "surname cannot be blank")
    private String name;
    @Column(name = "surname",nullable = false)
    @NotBlank(message = "surname cannot be blank")
    private String surname;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "birth_date",nullable = false)
    @NotBlank(message = "birthday can not be blank")
    private Date birthDate;
    @Column(name = "position",nullable = false)
    private Position position;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "mother_name")
    private String motherName;
    @Column(name = "gender")
    private GenderEnum gender;
    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;
    @Column(name = "location")
    private String location;
    @Column(name = "email",unique = true)
    private String email;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false,updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime updatedAt;

    @Builder.Default
    @ManyToMany
    @ToString.Exclude
    @JoinTable(name = "admin_roles",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_role_name"))
    private List<Role> roles = new ArrayList<>();

}
