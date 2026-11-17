package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement muiAlertMessage = $x("//div[contains(@class, 'MuiAlert-message') " +
            "and text()='Аккаунт создан. Войдите в систему.']").as("Сообщение об успешной регистрации");
    private final SelenideElement emailInput = $x("//input[@data-testid='email']")
            .as("Ввод email в поле авторизации");
    private final SelenideElement passwordInput = $x("//input[@data-testid='password']")
            .as("Ввод password в поле авторизации");
    private final SelenideElement buttonLogin = $x("//button[@type='submit' " +
            "and normalize-space()='Войти']").as("Кнопка входа в систему");

    @Step("Открыть страницу авторизации")
    public LoginPage openPage() {
        open("/login");
        return this;
    }

    @Step("Сообщение об успешной регистрации")
    public LoginPage checkSuccessfulRegistrationMessage() {
        muiAlertMessage.shouldHave(exactText("Аккаунт создан. Войдите в систему."));
        return this;
    }

    @Step("Ввести email в поле авторизации")
    public LoginPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Ввести пароль в поле на страницу авторизации")
    public LoginPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Клик по кнопке войти")
    public LoginPage clickButtonLogin() {
        buttonLogin.click();
        return this;
    }
}

