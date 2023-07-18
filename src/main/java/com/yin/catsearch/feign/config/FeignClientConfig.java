package com.yin.catsearch.feign.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class FeignClientConfig {
    @Value("${cat-api.key}")
    private String apiKey;

    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate -> requestTemplate.header("x-api-key", apiKey);
    }
}
