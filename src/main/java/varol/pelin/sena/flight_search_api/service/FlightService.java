package varol.pelin.sena.flight_search_api.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import varol.pelin.sena.flight_search_api.entity.Airport;
import varol.pelin.sena.flight_search_api.entity.Flight;
import varol.pelin.sena.flight_search_api.mapper.FlightMapper;
import varol.pelin.sena.flight_search_api.model.dto.FlightDto;
import varol.pelin.sena.flight_search_api.model.request.FlightRequest;
import varol.pelin.sena.flight_search_api.repository.FlightRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;
    private final AirportService airportService;

    public Flight getById(Long id) {
        return flightRepository.findById(id).orElseThrow();
    }

    public FlightDto getFlightById(Long id) {
        return flightMapper.convertToDto(getById(id));
    }

    public List<FlightDto> getAllFlights() {
        return flightMapper.flightDtoList(flightRepository.findAll());
    }


    public void create(FlightRequest flightRequest) {
        Airport arrivalAirport = airportService.getById(flightRequest.getArrivalAirport());
        Airport departureAirport = airportService.getById(flightRequest.getDepartureAirport());

        final Flight flight = Flight.builder()
                .departureAirport(departureAirport)
                .arrivalAirport(arrivalAirport)
                .departureDate(flightRequest.getDepartureDate())
                .returnDate(flightRequest.getReturnDate())
                .price(flightRequest.getPrice())
                .build();

        flightRepository.save(flight);
    }


    public void update(Long id, FlightRequest flightRequest) {
        Airport arrivalAirport = airportService.getById(flightRequest.getArrivalAirport());
        Airport departureAirport = airportService.getById(flightRequest.getDepartureAirport());

        final Flight flight = flightRepository.findById(id).orElseThrow();
        flight.setArrivalAirport(arrivalAirport);
        flight.setDepartureAirport(departureAirport);
        flight.setDepartureDate(flightRequest.getDepartureDate());
        flight.setReturnDate(flightRequest.getReturnDate());
        flight.setPrice(flightRequest.getPrice());
        flightRepository.save(flight);
    }

    public void delete(Long id) {
        Flight flight = getById(id);
        flight.setDeleted(true);
        flightRepository.save(flight);
    }

    public List<Flight> saveAll(List<Flight> flights) {
        return flightRepository.saveAll(flights);
    }

    public List<FlightDto> findAll(Specification<Flight> spec) {
        List<Flight> flights = flightRepository.findAll(spec);
        return flightMapper.flightDtoList(flights);
    }
}
