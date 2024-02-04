package varol.pelin.sena.flight_search_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import varol.pelin.sena.flight_search_api.entity.Flight;
import varol.pelin.sena.flight_search_api.model.dto.FlightDto;
import varol.pelin.sena.flight_search_api.model.request.FlightRequest;
import varol.pelin.sena.flight_search_api.model.request.SearchFlightRequest;
import varol.pelin.sena.flight_search_api.repository.FlightSpecification;
import varol.pelin.sena.flight_search_api.service.FlightService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping("/{id}")
    public FlightDto getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    @GetMapping
    public List<FlightDto> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/search")
    public ResponseEntity<List<FlightDto>> searchFlights(SearchFlightRequest searchFlightRequest) {

        Specification<Flight> spec = FlightSpecification.searchFlights(searchFlightRequest);
        List<FlightDto> flights = flightService.findAll(spec);

        return ResponseEntity.ok(flights);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody FlightRequest flightRequest) {
        flightService.create(flightRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody FlightRequest flightRequest) {
        flightService.update(id, flightRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        flightService.delete(id);
    }
}
