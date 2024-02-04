package varol.pelin.sena.flight_search_api.mapper;

import org.springframework.stereotype.Component;
import varol.pelin.sena.flight_search_api.entity.Airport;
import varol.pelin.sena.flight_search_api.entity.User;
import varol.pelin.sena.flight_search_api.model.dto.AirportDto;
import varol.pelin.sena.flight_search_api.model.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto convertToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

    public List<UserDto> userDtoList(List<User> users){
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
