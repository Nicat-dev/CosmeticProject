package com.example.cosmeticproject.security;

import com.example.cosmeticproject.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(SecurityFilter.class);

    JwtUtil jwtUtil;
    UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String requestHeader = request.getHeader("Authorization");
        String username = null;
        String authToken = null;

        if (Objects.nonNull(requestHeader) && requestHeader.startsWith("Bearer ")){
            authToken = requestHeader.substring(7);
            try {
                //we will get username from token its inside of claim :))
                username = jwtUtil.getUsernameFromToken(authToken);
            } catch (IllegalArgumentException e){
                log.error("an error occured during getting username from token", e);
            }catch (ExpiredJwtException e){
                log.warn("the token is expired and not valid anymore", e);
            }
        }else{
            log.warn("couldn't find bearer string, will ignore the header");
        }

        log.debug("checking authentication for user '{}' ",username);

        if (Objects.nonNull(username) && SecurityContextHolder.getContext().getAuthentication() == null){
            log.debug("security context was null, so authorization user");

            //we will get user's username for auth
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            //firstly we must validate our token for next step
            jwtUtil.validateToken(authToken);
            //
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

            //WebAuthenticationDetailsSource - It has a single responsibility to convert an instance
            // of HttpServletRequest class into an instance of the WebAuthenticationDetails class. You can think of it as a simple converter.
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            log.info("authorization user '{}' , setting security context", username);

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request,response);

    }
}
