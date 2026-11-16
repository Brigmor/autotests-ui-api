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
public class ApplicationEmploymentRequest {
    private String employmentType;
    private String employer;
    private String position;
    private Integer experienceMonths;
    private String monthlyIncome;
    private String monthlyExpenses;
    private String additionalIncome;
}
