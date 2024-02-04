package varol.pelin.sena.flight_search_api.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import varol.pelin.sena.flight_search_api.model.IdentityUser;
import varol.pelin.sena.flight_search_api.model.UserAuthentication;

public class IdentityUtils {

    public static IdentityUser getUser() {
        final UserAuthentication userAuthentication = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();
        return userAuthentication.getDetails();
    }
}
