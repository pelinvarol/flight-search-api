package varol.pelin.sena.flight_search_api.model.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
