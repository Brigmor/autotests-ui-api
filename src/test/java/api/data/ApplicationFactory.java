package api.data;

import api.models.request.ApplicationRequest;
import api.models.request.ApplicationEmploymentRequest;
import api.models.request.ApplicationLoanRequest;
import net.datafaker.Faker;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class ApplicationFactory {

    private static final Faker FAKER = new Faker(new Locale("ru"));

    public static ApplicationRequest createValidApplication() {

        LocalDate birthDate = LocalDate.of(2000, 11, 2);
        LocalDate issueDate = birthDate.plusYears(14);

        return ApplicationRequest.builder()
                .birthDate(birthDate.toString())
                .departmentCode("123-233")
                .firstName(FAKER.name().firstName())
                .gender("male")
                .issueDate(issueDate.toString())
                .lastName(FAKER.name().lastName())
                .middleName(FAKER.name().firstName())
                .passportNumber(FAKER.number().digits(6))
                .passportSeries(FAKER.number().digits(4))
                .registrationAddress(FAKER.address().fullAddress())
                .build();
    }
    public static ApplicationEmploymentRequest createValidApplicationStep2() {
        return  ApplicationEmploymentRequest.builder()
                .employmentType("employed")
                .employer("ООО " + FAKER.company().name())
                .position(FAKER.job().title())
                .experienceMonths(ThreadLocalRandom.current().nextInt(1, 361))
                .monthlyIncome(String.valueOf(BigDecimal.valueOf(
                        ThreadLocalRandom.current().nextInt(30_000, 300_001))))
                .monthlyExpenses(String.valueOf(BigDecimal.valueOf(
                        ThreadLocalRandom.current().nextInt(5_000, 100_001))))
                .additionalIncome(String.valueOf(BigDecimal.valueOf(
                        ThreadLocalRandom.current().nextInt(0, 50_001))))
                .build();
    }
    public static ApplicationLoanRequest createValidLoan() {

        return ApplicationLoanRequest.builder()
                .loanType("consumer")
                .loanAmount(ThreadLocalRandom.current().nextInt(50_000, 500_001))
                .termMonths(12)
                .purpose(FAKER.options().option(LOAN_PURPOSES.toArray(new String[0])))
                .comment(FAKER.lorem().sentence())
                .consent(true)
                .build();
    }
    private static final List<String> LOAN_PURPOSES = List.of(
            "repair",
            "car",
            "education",
            "other"
    );



}
