package com.example.cosmeticproject.security;

import com.example.cosmeticproject.entity.Adminstration;
import com.example.cosmeticproject.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Adminstration foundUser = adminRepository.findByUsername(username);
        return new UserDetailImpl(foundUser);
    }
}
