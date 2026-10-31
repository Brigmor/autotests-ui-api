package api.tests;

import api.testdata.UserFactory;
import org.example.models.UserRequest;
import org.junit.jupiter.api.Test;

public class ChacUserFactory {


    @Test
    void checkUserFactory() {
        UserRequest user = UserFactory.createValidUser();

        System.out.println(user.getFirstName());
        System.out.println(user.getEmail());
        System.out.println(user.getPhone());
    }
}
