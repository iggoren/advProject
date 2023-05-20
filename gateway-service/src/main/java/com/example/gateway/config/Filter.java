package com.example.gateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class Filter implements GatewayFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        var httpRequest = exchange.getRequest();
        if(httpRequest.getHeaders().containsKey("spring-cloud-course")){
           httpRequest.mutate().headers(httpHeaders -> httpHeaders.remove("spring-cloud-course"));
           return chain.filter(exchange);
        }
        return onError(exchange);
    }

    private Mono<Void> onError(ServerWebExchange exchange) {
        var response = exchange.getResponse();
        response.setStatusCode(HttpStatus.BAD_REQUEST);
        return response.setComplete();
    }
}
