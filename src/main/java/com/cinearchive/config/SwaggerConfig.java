package com.cinearchive.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {
        Info info = new Info();
        info.title("Cinearchive Archive - Swagger Documentation");
        info.version("1.0");
        info.description("Movie Catalog API Management");
        info.contact(new Contact().email("andre.szpyt@gmail.com").name("André Pinheiro"));

        return new OpenAPI().info(info);
    }
}
