package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.JwtDto;
import com.example.cosmeticproject.dto.request.LoginRequest;
import com.example.cosmeticproject.dto.response.BaseResponse;
import com.example.cosmeticproject.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    ResponseEntity<BaseResponse<JwtDto>> login(
            @RequestBody @Valid LoginRequest loginRequest){

        JwtDto jwtDto = authService.login(loginRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE,"You were successfully logged in",jwtDto));
    }

}
