package varol.pelin.sena.flight_search_api.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
