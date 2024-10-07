package com.identity.handler;

import com.identity.exception.ErrorCode;
import com.identity.exception.ServiceException;
import com.identity.dto.response.DefaultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
