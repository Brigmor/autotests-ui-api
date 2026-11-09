package utils;

import api.controllers.LoginUserController;
import api.controllers.RegisterUserController;
import api.data.UserFactory;
import api.models.request.LoginUserRequest;
import api.models.request.RegisterUserRequest;

public class LoginHelper {
    public static String registerAndLogin() {
        RegisterUserRequest user = UserFactory.createValidUser();

        RegisterUserController.postUser(user).statusCode(201);

        LoginUserRequest loginUser = LoginUserRequest.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        return LoginUserController.postLoginUser(loginUser)
                .extract()
                .path("accessToken");
    }



}
