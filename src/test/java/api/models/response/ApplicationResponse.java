package api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
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
    private ApplicationEmploymentResponse step2;
    private ApplicationLoanResponse step3;
    private List<Object> documents;
    private BigDecimal monthlyPayment;
    private Integer annualRate;
}
