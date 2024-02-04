package varol.pelin.sena.flight_search_api.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import varol.pelin.sena.flight_search_api.entity.Flight;
import varol.pelin.sena.flight_search_api.model.request.SearchFlightRequest;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlightSpecification {

//    public static Specification<Flight> searchFlights(SearchFlightRequest searchFlightRequest) {
//        return (Root<Flight> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
//            List<Predicate> predicates = new ArrayList<>();
//
//            predicates.add(criteriaBuilder.like(root.get("departureAirport").get("city"), searchFlightRequest.getDepartureAirport()));
//            predicates.add(criteriaBuilder.equal(root.get("arrivalAirport").get("city"), searchFlightRequest.getArrivalAirport()));
//            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("departureDate"), searchFlightRequest.getDepartureDate()));
//
//            if (searchFlightRequest.getReturnDate() != null) {
//                // Ensure both departure and return dates are within the valid date range
//                predicates.add(criteriaBuilder.between(root.get("departureDate"), searchFlightRequest.getDepartureDate(), searchFlightRequest.getReturnDate()));
//            } else {
//                // No return date provided, so just match departures from the specified date
//                predicates.add(criteriaBuilder.equal(root.get("departureDate"), searchFlightRequest.getDepartureDate()));
//            }
//
//            if (searchFlightRequest.getPrice() != null) {
//                predicates.add(criteriaBuilder.equal(root.get("price"), searchFlightRequest.getPrice()));
//            }
//
//            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//        };
//    }


    public static Specification<Flight> searchFlights(SearchFlightRequest searchFlightRequest) {
        return (Root<Flight> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (searchFlightRequest.getDepartureAirport() != null && !searchFlightRequest.getDepartureAirport().isEmpty()) {
                predicates.add((Predicate) criteriaBuilder.like(root.get("departureAirport").get("city"), searchFlightRequest.getDepartureAirport()));
            }

            if (searchFlightRequest.getArrivalAirport() != null && !searchFlightRequest.getArrivalAirport().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("arrivalAirport").get("city"), searchFlightRequest.getArrivalAirport()));
            }

            if (searchFlightRequest.getDepartureDate() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("departureDate"), searchFlightRequest.getDepartureDate()));
            }

            if (searchFlightRequest.getReturnDate() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("returnDate"), searchFlightRequest.getReturnDate()));
            }

            if (searchFlightRequest.getPrice() != null) {
                predicates.add(criteriaBuilder.equal(root.get("price"), searchFlightRequest.getPrice()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
