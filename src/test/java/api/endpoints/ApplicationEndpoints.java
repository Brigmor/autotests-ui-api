package api.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationEndpoints {
    CREATE("/api/applications"),
    STEP_2("/api/applications/%s/steps/2"),
    STEP_3("/api/applications/%s/steps/3");

    private final String path;

}
