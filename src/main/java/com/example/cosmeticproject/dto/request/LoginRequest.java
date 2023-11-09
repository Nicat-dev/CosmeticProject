package com.example.cosmeticproject.dto.request;

import com.example.cosmeticproject.validations.MatchPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NonNull @NotBlank @NotEmpty
    private String username;
    @MatchPassword
    private String password;
}
