package com.example.cosmeticproject.dto.request;

import com.example.cosmeticproject.enums.Position;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoctorRequest {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Position position;
    private String description;
}
