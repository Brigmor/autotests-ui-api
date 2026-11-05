package api.models.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequest {

    private String birthDate;
    private String departmentCode;
    private String firstName;
    private String gender;
    private String issueDate;
    private String lastName;
    private String middleName;
    private String passportNumber;
    private String passportSeries;
    private String registrationAddress;
}
