package com.example.cosmeticproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminstartionDto {
    private String name;
    private String surname;
    private String email;
    private String username;
    private String fatherName;
    private String motherName;
    private String phoneNumber;
    private String gender;
    private String maritalStatus;
    private String position;
    private String location;
}
