package com.identity.handler;

import com.identity.dto.response.DefaultResponse;
import com.identity.dto.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> execute(Object result, int... total) {
        DefaultResponse<Object> defaultResponse = DefaultResponse.builder()
                .code(2000)
                .message("success")
                .status(HttpStatus.OK)
                .result(result)
                .build();
        if (total.length != 0) defaultResponse.setTotal(total[0]);
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
