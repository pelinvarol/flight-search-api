package varol.pelin.sena.flight_search_api.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import varol.pelin.sena.flight_search_api.service.AuthService;

import java.io.IOException;

@Component
@RequiredArgsConstructor

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AuthService authService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authenticationHeader = request.getHeader("Authorization");
        if(authenticationHeader == null || !authenticationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request,response);
        } else {
            try {
                Authentication userAuthentication = authService.getUserAuthentication(request);
                SecurityContextHolder.getContext().setAuthentication(userAuthentication);
            } catch (MalformedJwtException m) {
                handleSecurityError(response, "JWT was not correctly constructed.");
                return;
            } catch (ExpiredJwtException e) {
                handleSecurityError(response, "Token is expired.");
                return;
            } catch (SignatureException e) {
                handleSecurityError(response, "Token is not valid.");
                return;
            }
            filterChain.doFilter(request, response);
        }
    }

    private void handleSecurityError(HttpServletResponse httpServletResponse, String message) throws IOException {
        SecurityContextHolder.clearContext();
        httpServletResponse.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

}