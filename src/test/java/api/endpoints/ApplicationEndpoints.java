package api.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationEndpoints {
    CREATE("/api/applications"),
    STEP_1("/api/applications/%s/steps/1"),
    STEP_2("/api/applications/%s/steps/2"),
    STEP_3("/api/applications/%s/steps/3"),
    SUBMIT_APPLICATION("/api/applications/%s/submit"),
    GET_DECISION("/api/applications/%s/decision"),
    DOWNLOAD_DOCUMENT("/api/applications/%s/documents/%s/download"),
    GET_DOCUMENT("/api/applications/%s/documents");

    private final String path;

}
