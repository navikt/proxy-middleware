package oksty.proxy.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    @Order(1)
    @SuppressWarnings({"java:S112", "java:S1130"}) // HttpSecurity.build() declares throws Exception
    public SecurityFilterChain internalEndpoints(HttpSecurity http) throws Exception {
        return http
                .securityMatcher("/internal/**")
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .build();
    }

    @Bean
    @Order(2)
    @ConditionalOnProperty("spring.security.oauth2.resourceserver.jwt.issuer-uri")
    @SuppressWarnings({"java:S112", "java:S1130"}) // HttpSecurity.build() declares throws Exception
    public SecurityFilterChain apiEndpoints(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> {}))
                .build();
    }
}
