package com.pfss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title("PFSS Swagger LNB API - OpenAPI 3.0")
                .description("This is a LNB server based on the OpenAPI 3.0 specification.")
                .termsOfService("http://localhost:8080/terms/")
                .version("1.0.0")
                .license(new License()
                    .name("Apache 2.0")
                    .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                .contact(new io.swagger.v3.oas.models.info.Contact()
                    .email("pfss@cn.panasonic.com")))
            .externalDocs(new ExternalDocumentation()
                    .description("Find more info here")
                    .url("https://swagger.io/"));
    }

}
