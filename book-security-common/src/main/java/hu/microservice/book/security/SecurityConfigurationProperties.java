package hu.book.oe;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "book.web.security")
@ConstructorBinding
public class SecurityConfigurationProperties {

    private final String jwksUri;
    private final boolean enabled;

    public SecurityConfigurationProperties(String jwksUri, boolean enabled) {
        this.jwksUri = jwksUri;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getJwksUri() {
        return jwksUri;
    }

}
