package com.example.gateway.config;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class Router {

    private final Filter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("client", r -> r.path("/api/client/**")
                        .filters(f -> f.filter(filter))
//                        .filters(f ->                  f.rewritePath("/api/book-service/(?.*)","/${remains}")
//                                .addRequestHeader("X-book-Header", "book-service-header")
                        .uri("lb://CLIENT-SERVICE/"))
                .build();
    }
}