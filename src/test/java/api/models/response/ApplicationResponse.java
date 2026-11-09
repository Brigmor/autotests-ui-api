package api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationResponse {

    private String id;
    private String userId;
    private String status;
    private OffsetDateTime createdAt;
    private OffsetDateTime decidedAt;
    private String rejectionReason;
    private Object step1;
    private Object step2;
    private Object step3;
    private List<Object> documents;
}
