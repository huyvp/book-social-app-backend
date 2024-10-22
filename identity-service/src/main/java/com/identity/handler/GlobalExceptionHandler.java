package com.identity.handler;

import com.identity.exception.ErrorCode;
import com.identity.exception.ServiceException;
import com.identity.dto.response.DefaultResponse;
import com.identity.security.JWTDecoderCustom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseEntity<Object> handleRestException(Exception e) {
        DefaultResponse<Object> response = DefaultResponse.builder()
                .timestamp(LocalDateTime.now())
                .code(ErrorCode.UNCATEGORIZED.getCode())
                .status(ErrorCode.UNCATEGORIZED.getHttpStatus())
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceException.class)
    ResponseEntity<Object> handleServiceException(ServiceException e) {
        DefaultResponse<Object> response = DefaultResponse.builder()
                .timestamp(LocalDateTime.now())
                .code(e.getErrorCode().getCode())
                .status(e.getErrorCode().getHttpStatus())
                .message(e.getErrorCode().getMessage())
                .build();
        return ResponseEntity.status(e.getErrorCode().getHttpStatus()).body(response);
    }
    // Security

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    ResponseEntity<Object> handleAccessDeniedException() {
        DefaultResponse<Object> response = DefaultResponse.builder()
                .timestamp(LocalDateTime.now())
                .code(ErrorCode.AUTH_4000.getCode())
                .status(ErrorCode.AUTH_4000.getHttpStatus())
                .message(ErrorCode.AUTH_4000.getMessage())
                .build();
        return ResponseEntity
                .status(ErrorCode.AUTH_4000.getHttpStatus())
                .body(response);
    }

    @ExceptionHandler(value = JwtException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<Object> handleInvalidTokenException(AccessDeniedException e) {
        DefaultResponse<Object> response = DefaultResponse.builder()
                .timestamp(LocalDateTime.now())
                .code(ErrorCode.AUTH_4001.getCode())
                .status(ErrorCode.AUTH_4001.getHttpStatus())
                .message(ErrorCode.AUTH_4001.getMessage())
                .build();
        return ResponseEntity
                .status(ErrorCode.AUTH_4001.getHttpStatus())
                .body(response);
    }
}
