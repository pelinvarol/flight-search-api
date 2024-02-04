package varol.pelin.sena.flight_search_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import varol.pelin.sena.flight_search_api.model.dto.FlightDto;
import varol.pelin.sena.flight_search_api.model.request.FlightRequest;
import varol.pelin.sena.flight_search_api.service.FlightService;

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
