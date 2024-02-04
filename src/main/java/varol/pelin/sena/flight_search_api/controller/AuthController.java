package varol.pelin.sena.flight_search_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import varol.pelin.sena.flight_search_api.model.request.LoginRequest;
import varol.pelin.sena.flight_search_api.model.request.RegisterRequest;
import varol.pelin.sena.flight_search_api.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegisterRequest request) {
        authService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) throws Exception {
        return ResponseEntity.ok(authService.login(request));
    }
}