package varol.pelin.sena.flight_search_api.service;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import varol.pelin.sena.flight_search_api.config.PasswordEncoder;
import varol.pelin.sena.flight_search_api.entity.User;
import varol.pelin.sena.flight_search_api.mapper.IdentityUserMapper;
import varol.pelin.sena.flight_search_api.mapper.UserMapper;
import varol.pelin.sena.flight_search_api.model.UserAuthentication;
import varol.pelin.sena.flight_search_api.model.request.LoginRequest;
import varol.pelin.sena.flight_search_api.model.request.RegisterRequest;
import varol.pelin.sena.flight_search_api.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final IdentityUserMapper identityUserMapper;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    @Transactional
    public void register(RegisterRequest request) {
        final User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.bCryptPasswordEncoder().encode(request.getPassword()))
                .build();

        userRepository.save(user);
    }

    public Authentication getUserAuthentication(HttpServletRequest httpServletRequest) {
        final Claims claims = tokenService.getTokenClaims(httpServletRequest);
        return new UserAuthentication(identityUserMapper.getUser(claims));
    }

    public String login(LoginRequest request) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("DisabledException");
        }

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        return tokenService.createToken(userMapper.convertToDto(user));

    }

}
