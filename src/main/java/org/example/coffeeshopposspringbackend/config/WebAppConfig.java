package org.example.coffeeshopposspringbackend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "org.example.coffeeshopposspringbackend")
@EnableWebMvc
@EnableJpaRepositories(basePackages = "org.example.coffeeshopposspringbackend")
@EnableTransactionManagement
public class WebAppConfig {
}
