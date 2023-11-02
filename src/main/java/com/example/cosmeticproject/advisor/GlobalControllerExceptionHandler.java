package com.example.cosmeticproject.advisor;


import com.example.cosmeticproject.dto.response.MetaResponse;
import com.example.cosmeticproject.exception.ResourceExistsException;
import com.example.cosmeticproject.exception.ResourceNotFoundException;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.example.cosmeticproject.enums.ESecurityMessage.NOT_ENOUGH_PERMISSION;
import static java.lang.Boolean.FALSE;
import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {
    private final MessageSource messageSource;


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MetaResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return ResponseEntity
                .status(NOT_FOUND)
                .body(new MetaResponse(FALSE, NOT_FOUND.value(), ex.getLocalizedMessage().toUpperCase()));
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<MetaResponse> handleUsernameNotFoundException(UsernameNotFoundException ex, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new MetaResponse(FALSE, NOT_FOUND.value(), ex.getLocalizedMessage().toUpperCase()));
    }

    @ExceptionHandler(ResourceExistsException.class)
    public ResponseEntity<MetaResponse> handleResourceExistException(ResourceExistsException ex, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new MetaResponse(FALSE, CONFLICT.value(), ex.getLocalizedMessage().toUpperCase()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<MetaResponse> handleResourceModifyException(IllegalArgumentException ex, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(FALSE, BAD_REQUEST.value(), ex.getLocalizedMessage().toUpperCase()));
    }

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<MetaResponse> handleDisabledException(DisabledException ex, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(FALSE, BAD_REQUEST.value(), ex.getLocalizedMessage().toUpperCase()));
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<MetaResponse> handleJwtException(JwtException ex, WebRequest request) {
        return ResponseEntity
                .status(UNAUTHORIZED)
                .body(new MetaResponse(FALSE, UNAUTHORIZED.value(), ex.getLocalizedMessage().toUpperCase()));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<MetaResponse> handleBadCredentialsException(BadCredentialsException ex, WebRequest request) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new MetaResponse(FALSE, BAD_REQUEST.value(), ex.getLocalizedMessage().toUpperCase()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<MetaResponse> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        return ResponseEntity
                .status(FORBIDDEN)
                .body(new MetaResponse(FALSE, FORBIDDEN.value(), NOT_ENOUGH_PERMISSION.getValue()));
    }

    @ExceptionHandler(LockedException.class)
    public ResponseEntity<MetaResponse> handleLockedException(LockedException ex, WebRequest request) {
        return ResponseEntity
                .status(UNAUTHORIZED)
                .body(new MetaResponse(FALSE, UNAUTHORIZED.value(), NOT_ENOUGH_PERMISSION.getValue()));
    }

    private List<String> processAllErrors(List<ObjectError> allErrors) {
        return allErrors.stream().map(this::resolveLocalizedErrorMessage).collect(Collectors.toList());
    }

    private String resolveLocalizedErrorMessage(ObjectError objectError) {
        Locale currentLocale = LocaleContextHolder.getLocale();
        String localizedErrorMessage = messageSource.getMessage(objectError, currentLocale);
        log.info(localizedErrorMessage);
        return localizedErrorMessage;
    }
}
