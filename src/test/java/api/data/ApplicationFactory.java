package api.data;

import api.models.request.ApplicationRequest;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;

public class ApplicationFactory {

    private static final Faker FAKER = new Faker(new Locale("ru"));

    public static ApplicationRequest createValidApplication() {
        //Надо зарандомить
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

}
