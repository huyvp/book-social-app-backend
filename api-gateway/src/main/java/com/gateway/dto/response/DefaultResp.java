package com.gateway.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DefaultResp<T> {
    @JsonFormat(pattern = "HH:mm:ss yyyy-MM-dd", timezone = "Asia/Bangkok")
    private LocalDateTime timestamp;
    private int code;
    private HttpStatus status;
    private String message;
    @Setter
    private Integer total;
    private T result;
}