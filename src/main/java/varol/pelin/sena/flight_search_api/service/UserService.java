package varol.pelin.sena.flight_search_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import varol.pelin.sena.flight_search_api.config.PasswordEncoder;
import varol.pelin.sena.flight_search_api.entity.User;
import varol.pelin.sena.flight_search_api.mapper.UserMapper;
import varol.pelin.sena.flight_search_api.model.dto.AirportDto;
import varol.pelin.sena.flight_search_api.model.dto.UserDto;
import varol.pelin.sena.flight_search_api.model.request.UserRequest;
import varol.pelin.sena.flight_search_api.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow();
    }

    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void delete(Integer id) {
        User user = userRepository.findById(id).orElseThrow();
        user.setDeleted(true);
        userRepository.save(user);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(Integer id, UserRequest request) {
        final User user = userRepository.findById(id).orElseThrow();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.bCryptPasswordEncoder().encode(request.getPassword()));
        userRepository.save(user);
    }

    public List<UserDto> getAllUsers() {
        return userMapper.userDtoList((userRepository.findAll()));
    }
}