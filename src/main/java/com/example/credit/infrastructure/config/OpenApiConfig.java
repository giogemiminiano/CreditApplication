package com.example.credit.infrastructure.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI creditApplicationApi(){
        return new OpenAPI().info(new Info().title("Solicitud de Credito")
                .description("Api para la creación de solicitudes y su seguimiento.")
                .version("1.0.0")).externalDocs(
                        new ExternalDocumentation().description("Respositorio")
                                .url("https://github.com/giogemiminiano/CreditApplication.git"));
    }
}
