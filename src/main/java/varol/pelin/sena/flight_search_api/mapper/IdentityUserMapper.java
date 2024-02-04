package varol.pelin.sena.flight_search_api.mapper;

import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import varol.pelin.sena.flight_search_api.model.IdentityUser;

import java.util.Objects;

@Component
public class IdentityUserMapper {

    public IdentityUser getUser(Claims claims) {
        return IdentityUser.builder()
                .id(Integer.valueOf(Objects.requireNonNull(getStringValue(claims, "id"))))
                .email(getStringValue(claims, "email"))
                .build();
    }

    private String getStringValue(Claims claims, String key) {
        final Object foundValue = claims.getOrDefault(key, StringUtils.EMPTY);
        return foundValue == null ? null : foundValue.toString();
    }
}
