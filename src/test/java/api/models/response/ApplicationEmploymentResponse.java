package api.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationEmploymentResponse {

    private String employmentType;
    private String employer;
    private String position;
    private Integer experienceMonths;
    private String monthlyIncome;
    private String monthlyExpenses;
    private String additionalIncome;
}
