package com.sezeme.cqrs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing /* <- 이게 있어야 활성화됨! */
public class JpaConfig {
}
