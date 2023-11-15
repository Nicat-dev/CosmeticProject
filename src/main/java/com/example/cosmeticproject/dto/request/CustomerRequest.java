package com.example.cosmeticproject.dto.request;

import com.example.cosmeticproject.enums.GenderEnum;
import com.example.cosmeticproject.enums.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private Long id;
    private String name;
    private String surname;
    private Date birthDate;
    private String email;
    private String fatherName;
    private String motherName;
    private String workLocation;
    private String phoneNumber;
    private GenderEnum gender;
    private MaritalStatus maritalStatus;
    private String location;
    private String finCode;
}
