package varol.pelin.sena.flight_search_api.mapper;

import org.springframework.stereotype.Component;
import varol.pelin.sena.flight_search_api.entity.Airport;
import varol.pelin.sena.flight_search_api.model.dto.AirportDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AirportMapper {
    public AirportDto convertToDto(Airport airport) {
        return AirportDto.builder()
                .id(airport.getId())
                .city(airport.getCity())
                .build();
    }

    public List<AirportDto> airportDtoList(List<Airport> airports){
        return airports.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
