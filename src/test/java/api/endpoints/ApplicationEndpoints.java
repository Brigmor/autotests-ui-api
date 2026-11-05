package api.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationEndpoints {
    CREATE("/api/applications");

    private final String path;

}
