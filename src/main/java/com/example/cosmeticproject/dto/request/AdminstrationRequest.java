package com.example.cosmeticproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminstrationRequest {
    private Long id;
    private String name;
    private String surname;
    private String gmail;
    private String username;
    private String fatherName;
    private String motherName;
    private String phoneNumber;
    private String gender;
    private String maritalStatus;
    private String location;
}
