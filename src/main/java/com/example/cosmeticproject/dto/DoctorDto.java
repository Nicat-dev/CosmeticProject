package com.example.cosmeticproject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoctorDto {
    private String name;
    private String surname;
    private String email;
    private String position;
    private String description;
}
