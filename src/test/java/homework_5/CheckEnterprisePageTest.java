package homework_5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Тест проверяет открытие страницы Enterprise на сайте Github.com
 */
public class CheckEnterprisePageTest {

    @BeforeAll
    public static void settingsForTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void checkingEnterprisePageTest() {
        open("https://github.com");
        $(withTagAndText("button", "Solutions")).shouldBe(visible).hover();
        $(withTagAndText("a", "Enterprise"))
                .shouldHave(attribute("href", "https://github.com/enterprise"))
                .click();
        $("#hero-section-brand-heading").shouldBe(visible).shouldHave(text("The AI-powered developer platform."));
    }
}