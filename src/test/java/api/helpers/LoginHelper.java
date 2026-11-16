package api.helpers;

import api.controllers.LoginUserController;
import api.controllers.RegisterUserController;
import api.data.UserFactory;
import api.models.request.LoginUserRequest;
import api.models.request.RegisterUserRequest;

public class LoginHelper {

    private static final ThreadLocal<String> TOKEN = new ThreadLocal<>();

    public static String registerAndLogin() {
        String token = TOKEN.get();

        if (token != null) {
            return token;
        }
        RegisterUserRequest user = UserFactory.createValidUser();
        RegisterUserController.postUser(user).statusCode(201);
        LoginUserRequest loginUser = LoginUserRequest.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        token = LoginUserController.postLoginUser(loginUser)
                .extract()
                .path("accessToken");

        TOKEN.set(token);
        return token;
    }

    public static void clearToken() {
        TOKEN.remove();
    }
}
