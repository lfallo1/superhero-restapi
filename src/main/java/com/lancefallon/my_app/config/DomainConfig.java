package com.lancefallon.my_app.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan(basePackages = {"com.lancefallon.my_app.domain"})
@EnableJpaRepositories(basePackages = {"com.lancefallon.my_app.repos"})
@EnableTransactionManagement
public class DomainConfig {
}
