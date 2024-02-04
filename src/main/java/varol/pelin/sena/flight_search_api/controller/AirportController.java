package varol.pelin.sena.flight_search_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import varol.pelin.sena.flight_search_api.entity.Airport;
import varol.pelin.sena.flight_search_api.model.dto.AirportDto;
import varol.pelin.sena.flight_search_api.model.request.AirportRequest;
import varol.pelin.sena.flight_search_api.service.AirportService;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;

    @GetMapping("/{id}")
    public AirportDto getAirportById(@PathVariable Long id) {
        return airportService.getAirportById(id);
    }

    @GetMapping
    public List<AirportDto> getAllAirports() {
        return airportService.getAllAirports();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody AirportRequest airportRequest) {
        airportService.update(id, airportRequest);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody AirportRequest airportRequest) {
        airportService.create(airportRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        airportService.delete(id);
    }
}
