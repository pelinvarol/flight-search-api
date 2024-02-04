package varol.pelin.sena.flight_search_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import varol.pelin.sena.flight_search_api.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>, JpaSpecificationExecutor<Flight> {
    Page<Flight> findAll(Specification<Flight> spec, Pageable pageable);
}
