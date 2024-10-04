package com.identity.handler;

import com.identity.response.DefaultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> execute(Object result, int total) {
        DefaultResponse<Object> defaultResponse = DefaultResponse.builder()
                .code(2000)
                .message("success")
                .status(HttpStatus.OK)
                .result(result)
                .total(total)
                .build();
        return ResponseEntity.ok(defaultResponse);
    }

    public static ResponseEntity<Object> execute() {
        DefaultResponse<Object> defaultResponse = DefaultResponse.builder()
                .code(2000)
                .message("success")
                .status(HttpStatus.OK)
                .build();
        return ResponseEntity.ok(defaultResponse);
    }
}
