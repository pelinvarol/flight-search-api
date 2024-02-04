package varol.pelin.sena.flight_search_api.model;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
public class UserAuthentication implements Authentication {

    @Serial
    private static final long serialVersionUID = -1;

    @Getter
    private final IdentityUser identityUser;

    private boolean authenticated = true;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public IdentityUser getDetails() {
        return identityUser;
    }

    @Override
    public Integer getPrincipal() {
        return identityUser.getId();
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = authenticated;
    }

    @Override
    public String getName() {
        return null;
    }
}
