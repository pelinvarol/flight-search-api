package varol.pelin.sena.flight_search_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import varol.pelin.sena.flight_search_api.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long > {
}
