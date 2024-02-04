package varol.pelin.sena.flight_search_api.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdentityUser {
    private Integer id;
    private String email;
}
