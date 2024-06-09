package homework_4;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Тест проверяет поиск страницы Soft Assertions в Selenide проекте на сайте Github.com
 */
public class CheckSearchSoftAssertionsPageTest {

    @BeforeAll
    public static void settingsForTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void checkingSearchSoftAssertionsPageTest() {
        open("/selenide/selenide");
        $("#repository-container-header").shouldBe(visible).shouldHave(text("selenide / selenide"));
        $("#wiki-tab").click();
        $("#wiki-body").shouldHave(text("Welcome to the selenide wiki!"));
        $(".markdown-body ul").find(byText("Soft assertions")).shouldHave(text("Soft assertions")).click();
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class}) " +
                "class Tests { " +
                "  @Test " +
                "  void test() { " +
                "    Configuration.assertionMode = SOFT; " +
                "    open(\"page.html\"); " +
                " " +
                "    $(\"#first\").should(visible).click(); " +
                "    $(\"#second\").should(visible).click(); " +
                "  } " +
                "}"
        ));
    }
}