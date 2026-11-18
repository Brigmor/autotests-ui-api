package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {

    private final SelenideElement dashboardTitle = $x("//h4[normalize-space()='Личный кабинет']")
            .as("титульник личный кабинет");

    private final SelenideElement createApplicationButton = $x(
            "//button[@data-testid='create-application']").as("кнопка создать новую заявку");


    @Step("проверить титульник страницы 'личный кабинет'")
    public DashboardPage checkDashboardTitle() {
        dashboardTitle.shouldHave(Condition.exactText("Личный кабинет"));
        return this;
    }

    private DashboardPage clickButtonCreateApp() {
        createApplicationButton.click();
        return this;
    }

}
