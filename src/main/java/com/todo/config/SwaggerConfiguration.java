package com.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

    private static String title ="to-do-list Api";
    private static String description ="Spring boot를 활용한 to-do-list 개발";
    private static String version ="1.0.0";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().components(new Components()).info(apiInfo());
    }

    private Info apiInfo() {
        return new Info().title(title).description(description).version(version);
    }
    
}
