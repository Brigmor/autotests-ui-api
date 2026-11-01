package api.data;

import api.models.request.UserRequest;
import net.datafaker.Faker;

public class UserFactory {

    private static final Faker FAKER = new Faker();

    public static UserRequest createValidUser() {
        final String password = "Test12345!";
        return UserRequest.builder()
                .firstName(FAKER.name().firstName())
                .lastName(FAKER.name().lastName())
                .phone("+7" + FAKER.number().digits(10))
                .email(FAKER.internet().emailAddress())
                .password(password)
                .confirmPassword(password)
                .consent(true)
                .build();
    }
}