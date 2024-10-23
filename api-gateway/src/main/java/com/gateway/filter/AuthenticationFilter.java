package com.gateway.filter;

import com.gateway.service.IdentityService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationFilter implements Ordered, GlobalFilter {
    IdentityService identityService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String requestId = exchange.getRequest().getId();
        log.info("[{}] Start authentication filter request", requestId);
        String path = exchange.getRequest().getPath().toString();
        String method = exchange.getRequest().getMethod().toString();
        List<String> authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION);

        log.info("[{}] Method: {} - Path: {}", requestId, method, path);
        log.info("[{}] Headers: {}", requestId, authHeader);

        /*if (CollectionUtils.isEmpty(authHeader))
            return unAuthentication(exchange.getResponse());
        String token = authHeader.get(0);
        log.info("Token authorization: {}", token);
        identityService.introspect(token).subscribe(
                res -> log.info("Result: {}", res.getResult())
        );*/

        log.info("[{}] End authentication filter request \n", requestId);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }

    Mono<Void> unAuthentication(ServerHttpResponse response) {
        String msg = "UnAuthentication";
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.writeWith(
                Mono.just(response.bufferFactory().wrap(msg.getBytes()))
        );
    }
}
