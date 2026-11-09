package api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationLoanResponse {

    private String loanType;
    private Integer loanAmount;
    private Integer termMonths;
    private String purpose;
    private String comment;
    private Boolean consent;
}
