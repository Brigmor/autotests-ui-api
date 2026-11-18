package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ApplicationPage {

    private final SelenideElement firstNameInput = $x("//input[@data-testid='firstName']")
            .as("поле ввода имени");

    private final SelenideElement lastNameInput = $x("//input[@data-testid='lastName']")
            .as("поле ввода фамилии");

    private final SelenideElement middleNameInput = $x("//input[@data-testid='middleName']")
            .as("поле ввода отчества");

    private final SelenideElement birthDate = $x("//input[@data-testid='birthDate']")
            .as("поле ввода даты рождения");

    private final SelenideElement genderSelect =
            $x("//div[@role='combobox' and normalize-space()='Мужской']").as("выпадающий список");

    private final SelenideElement maleOption =
            $x("//li[@role='option' and @data-value='male']").as("Выбрать мужской пол");

    private final SelenideElement femaleOption =
            $x("//li[@role='option' and @data-value='female']").as("Выбрать женский пол");

    private final SelenideElement passportSeriesInput = $x("//input[@data-testid='passportSeries']")
            .as("поле ввода серии паспорта");

    private final SelenideElement passportNumberInput = $x("//input[@data-testid='passportNumber']")
            .as("поле ввода номера паспорта");

    private final SelenideElement issueDateInput = $x("//input[@data-testid='issueDate']")
            .as("поле ввода даты выдачи паспорта");

    private final SelenideElement departmentCodeInput = $x("//input[@data-testid='departmentCode']")
            .as("поле ввода 'код подразделения'");

    private final SelenideElement registrationAddressInput = $x(
            "//input[@data-testid='registrationAddress']").as("поле адреса регистрации");

    @Step("Ввести имя: {firstName}")
    public ApplicationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Ввести фамилию: {lastName}")
    public ApplicationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Ввести отчество: {middleName}")
    public ApplicationPage setMiddleName(String middleName) {
        middleNameInput.setValue(middleName);
        return this;
    }

    @Step("Ввести дату рождения: {date}")
    public ApplicationPage setBirthDate(String date) {
        birthDate.setValue(date);
        return this;
    }

    @Step("Выбрать мужской пол")
    public ApplicationPage selectMale() {
        genderSelect.click();
        maleOption.click();
        return this;
    }

    @Step("Выбрать женский пол")
    public ApplicationPage selectFemale() {
        genderSelect.click();
        femaleOption.click();
        return this;
    }

    @Step("Ввести серию паспорта: {passportSeries}")
    public ApplicationPage setPassportSeries(String passportSeries) {
        passportSeriesInput.setValue(passportSeries);
        return this;
    }

    @Step("Ввести номер паспорта: {passportNumber}")
    public ApplicationPage setPassportNumber(String passportNumber) {
        passportNumberInput.setValue(passportNumber);
        return this;
    }

    @Step("Ввести дату выдачи паспорта: {issueDate}")
    public ApplicationPage setIssueDate(String issueDate) {
        issueDateInput.setValue(issueDate);
        return this;
    }

    @Step("Ввести код подразделения: {departmentCode}")
    public ApplicationPage setDepartmentCode(String departmentCode) {
        departmentCodeInput.setValue(departmentCode);
        return this;
    }

    @Step("Ввести адрес регистрации: {address}")
    public ApplicationPage setRegistrationAddress(String address) {
        registrationAddressInput.setValue(address);
        return this;
    }


}
