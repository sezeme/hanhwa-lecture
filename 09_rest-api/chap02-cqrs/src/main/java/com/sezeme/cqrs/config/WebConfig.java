package com.sezeme.cqrs.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    registry.addMapping("/**") // 모든 경로에 대해
            .allowedOrigins
}
