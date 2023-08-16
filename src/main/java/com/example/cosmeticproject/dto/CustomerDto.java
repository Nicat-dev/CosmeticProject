package com.example.cosmeticproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private String name;
    private String surname;
    private String gmail;
    private String fatherName;
    private String motherName;
    private String phoneNumber;
    private String birthDate;
    private String gender;
    private String maritalStatus;
    private String location;
    private String workLocation;
    private String finCode;
}
