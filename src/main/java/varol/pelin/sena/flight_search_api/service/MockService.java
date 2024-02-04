package varol.pelin.sena.flight_search_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import varol.pelin.sena.flight_search_api.entity.Airport;
import varol.pelin.sena.flight_search_api.entity.Flight;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class MockService {

    private final FlightService flightService;
    private final AirportService airportService;

    private final String[] CITIES = {
            "İstanbul", "Ankara", "İzmir", "Samsun", "Adana", "Antalya", "Rome", "Londra", "Berlin", "Paris", "Münih",
            "Edinburgh", "Amsterdam", "Viyana", "Barcelona", "Kopenhag", "Milano", "Lizbon"
    };

    public List<Flight> getFlights() {
        List<Flight> flights = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            LocalDateTime departureDate = generateRandomLocalDateTime();
            LocalDateTime returnDate = generateRandomLocalDateTime();

            if (returnDate.isBefore(departureDate)) {
                returnDate = departureDate.plusDays(ThreadLocalRandom.current().nextLong(1, 31));
            }
            final Flight flight = Flight.builder()
                    .departureAirport(generateRandomAirport())
                    .arrivalAirport(generateRandomAirport())
                    .departureDate(departureDate)
                    .returnDate(returnDate)
                    .price(generateRandomPrice())
                    .build();

            flights.add(flight);
        }
        return flights;
    }

    public LocalDateTime generateRandomLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        ThreadLocalRandom random = ThreadLocalRandom.current();

        long daysToAdd = random.nextLong(1, 31);
        long hoursToAdd = random.nextLong(24);
        long minutesToAdd = random.nextLong(60);
        long secondsToAdd = random.nextLong(60);

        LocalDateTime randomTime = now.plusDays(daysToAdd)
                .plusHours(hoursToAdd)
                .plusMinutes(minutesToAdd)
                .plusSeconds(secondsToAdd);
        return randomTime;
    }

    private Double generateRandomPrice() {
        Double price = ThreadLocalRandom.current().nextDouble(300, 10000);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedPrice = decimalFormat.format(price);
        try {
            return decimalFormat.parse(formattedPrice).doubleValue();
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing price: " + formattedPrice, e);
        }
    }

    private String getRandomCity() {
        int randomIndex = ThreadLocalRandom.current().nextInt(CITIES.length);
        return CITIES[randomIndex];
    }

    private Airport generateRandomAirport() {
        final Airport airport = Airport.builder()
                .city(getRandomCity())
                .build();

        airportService.save(airport);
        return airport;
    }

    @Scheduled(cron = "0 0 0 * * *") // Will be executed once a day at midnight.
    public void getApiFlightData() {
        List<Flight> flights = getFlights();
        flightService.saveAll(flights);
    }
}
