package varol.pelin.sena.flight_search_api.config;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Configuration
@Slf4j
public class JwtConfiguration {

    @Value("${jwt.token.secret}")
    private String secret;

    public SecretKeySpec getSecretKeySpec() throws Exception {
        try {
            return new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), SignatureAlgorithm.HS512.getJcaName());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
