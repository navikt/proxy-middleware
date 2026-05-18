package oksty.proxy.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI proxyOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Proxy Middleware API")
                        .description("Middleware proxy for integrations between Nav services and external SaaS solutions")
                        .version("0.1.0")
                        .contact(new Contact()
                                .name("Team oksty")
                                .email("borse.schumacher.haraldsen@nav.no")));
    }
}
