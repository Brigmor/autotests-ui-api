package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class RegisterPage {

    private final SelenideElement pageTitle =$x("//h4[text()='Регистрация']").as("поле регистрация на странице");
    private final SelenideElement firstNameInput = $x("//input[@data-testid='firstName']").as("поле ввода имени");
    private final SelenideElement lastNameInput = $x("//input[@data-testid='lastName']").as("поле ввода фамилии");
    private final SelenideElement emailInput =$x("//input[@data-testid='email']").as("поле ввода email");
    private final SelenideElement phoneInput = $x("//input[@data-testid='phone']").as("поле ввода телефона");
    private final SelenideElement passwordInput = $x("//input[@data-testid='password']").as("поле ввода пароля");
    private final SelenideElement confirmPasswordInput = $x("//input[@data-testid='confirmPassword']").as("поле ввода подтвердить пароль");
    private final SelenideElement checkboxInput =$x("//input[@type='checkbox']").as("чекбокс согласен с условиями");
    private final SelenideElement regButton =$x("//button[@data-testid='register-submit']").as("кнопка регистрации");

    @Step("Открыть страницу регистрации пользователя")
    public RegisterPage openPage() {
        open("/register");
        pageTitle.shouldBe(Condition.visible);
        return this;
    }
    @Step("Ввести имя на страцие регистрации")
    public RegisterPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }
    @Step("Ввести фамилию на странице регистрации")
    public RegisterPage setLastName(String lastName){
        lastNameInput.setValue(lastName);
        return this;
    }
    @Step("Ввести email на странице регистрации")
    public RegisterPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }
    @Step("Ввести телефон на странице регистрации")
    public RegisterPage setPhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }
    @Step("Ввести пароль на странице регистрации")
    public RegisterPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }
    @Step("Подтвердить пароль на странице регистрации")
    public RegisterPage setConfirmPassword(String confirmPassword) {
        confirmPasswordInput.setValue(confirmPassword);
        return this;
    }
    @Step("Принять условия регистрации")
    public RegisterPage acceptTerms() {
        checkboxInput.click();
        return this;
    }
    @Step("Нажать кнопку регистрация")
    public RegisterPage clickRegisterButton() {
        regButton.shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }
}
