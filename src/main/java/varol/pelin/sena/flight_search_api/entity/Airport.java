package varol.pelin.sena.flight_search_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "airports")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String city;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;
}
