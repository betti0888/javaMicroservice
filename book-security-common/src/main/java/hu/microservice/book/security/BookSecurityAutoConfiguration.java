package hu.book.oe;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookSecurityAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(AuthorizationSupplier.class)
    public AuthorizationSupplier tokenSupplier() {
        return new JwtAuthorizationSupplier();
    }

    @Bean
    @ConditionalOnMissingBean(AuthorizationHeaderInterceptor.class)
    public AuthorizationHeaderInterceptor oAuthTokenInterceptor(AuthorizationSupplier tokenSupplier) {
        return new AuthorizationHeaderInterceptor(tokenSupplier);
    }

    @Bean
    @ConditionalOnMissingBean(KeycloakTokenConverter.class)
    public KeycloakTokenConverter keycloakTokenConverter() {
        return new KeycloakTokenConverter();
    }

}
