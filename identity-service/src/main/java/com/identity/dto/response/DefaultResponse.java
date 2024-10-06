package com.identity.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DefaultResponse<T> {
    @JsonFormat(pattern = "HH:mm:ss yyyy-MM-dd", timezone = "Asia/Bangkok")
    private LocalDateTime timestamp;
    private int code;
    private HttpStatus status;
    private String message;
    private int total;
    private T result;
}
