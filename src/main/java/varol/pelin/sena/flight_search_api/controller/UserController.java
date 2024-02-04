package varol.pelin.sena.flight_search_api.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;
import varol.pelin.sena.flight_search_api.entity.User;
import varol.pelin.sena.flight_search_api.model.dto.AirportDto;
import varol.pelin.sena.flight_search_api.model.dto.UserDto;
import varol.pelin.sena.flight_search_api.model.request.AirportRequest;
import varol.pelin.sena.flight_search_api.model.request.UserRequest;
import varol.pelin.sena.flight_search_api.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody UserRequest userRequest) {
        userService.update(id, userRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        User user = userService.getById(id);
        user.setDeleted(true);
        userService.save(user);
    }
}
