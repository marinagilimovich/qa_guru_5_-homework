package tests.annotationSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int ISSUE_NUMBER = 68;

    @Step
    public void openMainPage() {
        open("https://github.com");
    }

    @Step
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
    }

    @Step
    public void goToRepository(String repository) {
        $(By.linkText(REPOSITORY)).click();
    }

    @Step
    public void clickIssuesTab() {
        $(withText("Issues")).click();
    }

    @Step
    public void checkIssueNumber(Integer issue_number) {
        $(withText("#" + ISSUE_NUMBER)).should(exist);
    }
}
