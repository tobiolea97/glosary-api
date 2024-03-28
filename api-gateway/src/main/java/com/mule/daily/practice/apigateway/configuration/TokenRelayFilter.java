package com.mule.daily.practice.apigateway.configuration;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class TokenRelayFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // Extract the Authorization header from the incoming request
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");

        // Check if the token is present
        if (token != null) {
            // Add the token to the request forwarded to downstream services
            ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
            builder.header("Authorization", token);
            return chain.filter(exchange.mutate().request(builder.build()).build());
        }

        // Forward the request without modification if the token is not present
        return chain.filter(exchange);
    }
}
