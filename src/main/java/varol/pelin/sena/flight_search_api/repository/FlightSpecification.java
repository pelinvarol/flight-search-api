package varol.pelin.sena.flight_search_api.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import varol.pelin.sena.flight_search_api.entity.Flight;
import varol.pelin.sena.flight_search_api.model.request.SearchFlightRequest;

import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlightSpecification {

//    public static Specification<Flight> getFilteredFlights(SearchFlightRequest searchFlightRequest) {
//
//        return (root, query, cb) -> {
//            Predicate departureAirportPredicate = cb.like(cb.lower(root.get(searchFlightRequest.getDepartureAirport())),likePattern(searchFlightRequest.getDepartureAirport()))
//            Predicate arrivalAirport = cb.like(cb.lower(root.get(searchFlightRequest.getArrivalAirport())),likePattern(searchFlightRequest.getArrivalAirport())
//            Predicate departureDate = cb.equal(root.get(String.valueOf(searchFlightRequest.getDepartureDate())), searchFlightRequest.getDepartureDate())
//            Predicate returnDate =
//
//            return cb.and(departureAirportPredicate, arrivalAirport,d)
//
//
//
//        };
//        return null;
//    }
//
//    private static String likePattern(String value) {
//        return "%" + value.toLowerCase() + "%";
//    }
}
