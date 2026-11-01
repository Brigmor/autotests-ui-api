package api.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserEndpoints {
    HEALTH("/health"),
    REGISTER("/api/auth/register"),
    LOGIN("/api/auth/login"),
    LOGOUT("/api/auth/logout"),
    ME("/api/users/me"),
    Update("/api/users/me"),
    CHANGE_PASSWORD("/api/users/me/password");

    private final String path;
}