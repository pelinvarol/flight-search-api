package varol.pelin.sena.flight_search_api.mapper;

import org.springframework.stereotype.Component;
import varol.pelin.sena.flight_search_api.entity.Flight;
import varol.pelin.sena.flight_search_api.model.dto.FlightDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightMapper {

    public FlightDto convertToDto(Flight flight) {
        return FlightDto.builder()
                .id(flight.getId())
                .departureAirport(flight.getDepartureAirport())
                .arrivalAirport(flight.getArrivalAirport())
                .departureDate(flight.getDepartureDate())
                .returnDate(flight.getReturnDate())
                .price(flight.getPrice())
                .build();
    }

    public List<FlightDto> flightDtoList(List<Flight> flights) {
        return flights.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
