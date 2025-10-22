package com.dws.application.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API for Musical Groups") // Título da sua API
                        .description("API REST to manage musical groups external data.")
                        .version("1.0.0") // Versão da sua API
                        .contact(new Contact()
                                .name("Leonardo Pregnolato/DWS")
                                .email("leopregnolato@outlook.com")
                        )
                );
    }
}
