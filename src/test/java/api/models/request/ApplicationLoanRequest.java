package api.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationLoanRequest {

    private String loanType;
    private Integer loanAmount;
    private Integer termMonths;
    private String purpose;
    private String comment;
    private Boolean consent;
}
