package com.example.cosmeticproject.dto.request;

import com.example.cosmeticproject.enums.GenderEnum;
import com.example.cosmeticproject.enums.MaritalStatus;
import com.example.cosmeticproject.enums.Position;
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
    private GenderEnum gender;
    private MaritalStatus maritalStatus;
    private Position position;
    private String location;
}
