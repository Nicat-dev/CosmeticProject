package com.example.cosmeticproject.security;

import com.example.cosmeticproject.dto.JwtDto;
import com.example.cosmeticproject.dto.request.LoginRequest;
import com.example.cosmeticproject.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthService {

    AuthenticationManager authenticationManager;
    JwtUtil jwtUtil;
    UserDetailsService userDetailsService;

    public JwtDto login(LoginRequest request) {
        authenticate(request.getUsername(), request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtUtil.doGenerate(userDetails);
        return new JwtDto(token);
    }

    private void authenticate(String username,String password){
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new DisabledException("user is disabled", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("bad credentials", e);
        }

    }

}
