package varol.pelin.sena.flight_search_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import varol.pelin.sena.flight_search_api.entity.Airport;
import varol.pelin.sena.flight_search_api.mapper.AirportMapper;
import varol.pelin.sena.flight_search_api.model.dto.AirportDto;
import varol.pelin.sena.flight_search_api.model.request.AirportRequest;
import varol.pelin.sena.flight_search_api.repository.AirportRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    public Airport getById(Long id) {
        return airportRepository.findById(id).orElseThrow();
    }

    public AirportDto getAirportById(Long id) {
        return airportMapper.convertToDto(getById(id));
    }

    public List<AirportDto> getAllAirports() {
        return airportMapper.airportDtoList((airportRepository.findAll()));
    }

    public void create(AirportRequest request) {
        final Airport airport = Airport.builder().city(request.getCity()).build();
        airportRepository.save(airport);
    }

    public void update(Long id, AirportRequest request) {
        final Airport airport = airportRepository.findById(id).orElseThrow();
        airport.setCity(request.getCity());
        airportRepository.save(airport);
    }

    public void delete(Long id) {
        Airport airport = getById(id);
        airport.setDeleted(true);
        airportRepository.save(airport);
    }

    public void save(Airport airport) {
        airportRepository.save(airport);
    }
}
