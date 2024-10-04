package org.example.coffeeshopposspringbackend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "org.example.coffeeshopposspringbackend")
@EnableWebMvc
public class WebAppConfig {
}
