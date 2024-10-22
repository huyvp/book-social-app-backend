package com.gateway.service;

import com.gateway.client.IdentityClient;
import com.gateway.dto.request.AuthReq;
import com.gateway.dto.response.DefaultResp;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IdentityService {
    IdentityClient identityClient;

    public Mono<DefaultResp<Object>> introspect(String token) {
        return identityClient.introspect(
                AuthReq.builder()
                        .token(token)
                        .build()
        );
    }
}
