package varol.pelin.sena.flight_search_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @Column(nullable = false)
    private LocalDateTime departureDate;

    @Column(nullable = true)
    private LocalDateTime returnDate;

    @Column(nullable = false)
    private Double price;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;
}
