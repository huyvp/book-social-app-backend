package com.gateway.client;

import com.gateway.dto.request.AuthReq;
import com.gateway.dto.response.DefaultResp;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

@Repository
public interface IdentityClient {
    @PostExchange(url = "/auth/introspect", contentType = MediaType.APPLICATION_JSON_VALUE)
    Mono<DefaultResp<Object>> introspect(@RequestBody AuthReq authReq);
}
