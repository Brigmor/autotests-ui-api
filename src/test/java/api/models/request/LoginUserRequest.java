package api.models.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserRequest {

    private String email;
    private String password;
}
