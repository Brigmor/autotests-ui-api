package api.tests;

import api.testdata.UserFactory;
import net.datafaker.Faker;
import org.example.models.request.UserRequest;
import org.junit.jupiter.api.Test;

public class FacerTest {


    @Test
    void generateData() {
        Faker faker = new Faker();

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.internet().emailAddress());
    }


    @Test
    void checkUserFactory() {

        UserRequest user = UserFactory.createUser(
                u -> u.setEmail("invalid-email")
        );

        System.out.println(user.getFirstName());
        System.out.println(user.getEmail());
    }
}
