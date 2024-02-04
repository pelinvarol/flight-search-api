package varol.pelin.sena.flight_search_api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightRequest {

    private Long departureAirport;
    private Long arrivalAirport;
    private LocalDateTime departureDate;
    private LocalDateTime returnDate;
    private Double price;
}
