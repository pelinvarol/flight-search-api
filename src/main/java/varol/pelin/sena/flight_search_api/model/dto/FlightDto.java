package varol.pelin.sena.flight_search_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import varol.pelin.sena.flight_search_api.entity.Airport;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
    private Long id;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureDate;
    private LocalDateTime returnDate;
    private Double price;

}
