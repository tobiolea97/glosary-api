package com.mule.daily.practice.apigateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public TokenRelayFilter tokenRelayFilter() {
        return new TokenRelayFilter();
    }
}
