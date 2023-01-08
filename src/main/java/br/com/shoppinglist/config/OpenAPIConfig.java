package br.com.shoppinglist.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("shopping-list-java")
                .pathsToMatch("/v1/**")
                .build();
    }

    public OpenAPI shoppingListOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API para uma lista de compras")
                .description("Itens, tipos de itens e listas.")
                        .version("v1"));
    }
}
