package tests.lambdaSteps;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CheckIssueNumberTestLambda {
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int ISSUE_NUMBER = 68;

    @Test
    public void testGitHub() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open the main page", () -> {
            open("https://github.com");
        });

        step("Looking for the repository", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
            $(By.linkText(REPOSITORY)).click();
        });

        step("Going to Issues tab", () -> {
            $(withText("Issues")).click();
        });

        step("Looking for the issue", () -> {
            $(withText("#" + ISSUE_NUMBER)).should(exist);
        });
    }
}
