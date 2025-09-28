package com.apiAggregator.apiAggregator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class FeignConfig {

    //Required configuration for using wikipedia API
    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            template.header("User-Agent", "ApiAggregatorApp (contact: ur_email)");
        };
    }
}
