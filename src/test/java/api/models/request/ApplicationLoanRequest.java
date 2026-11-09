package api.models.request;

import lombok.*;

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
