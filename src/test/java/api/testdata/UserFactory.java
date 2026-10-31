package api.testdata;

import net.datafaker.Faker;
import org.example.models.UserRequest;
import java.util.function.Consumer;
public class UserFactory {

    private static final Faker faker = new Faker();

    public static UserRequest createValidUser() {

        String password = "Test12345!";

        return new UserRequest(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                "+7" + faker.number().digits(10),
                password,
                password,
                true
        );
    }

    public static UserRequest createUser(Consumer<UserRequest> customizer) {

        UserRequest user = createValidUser();

        customizer.accept(user);

        return user;
    }

}
