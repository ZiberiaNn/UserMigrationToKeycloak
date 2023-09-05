package com.lotrading.usersmigration.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakClientConfig {
    @Bean
    Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .serverUrl("")
                .realm("")
                .clientId("")
                .grantType(OAuth2Constants.PASSWORD)
                .username("")
                .password("")
                .build();
    }
}
