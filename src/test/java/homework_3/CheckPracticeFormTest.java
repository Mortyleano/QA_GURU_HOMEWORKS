package homework_3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Тест проверяет заполнение формы регистрации студента и получение результатов отправки
 */
public class CheckPracticeFormTest {

    @BeforeAll
    public static void settingsTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void сheckingPracticeFormTest() {
        /*
          Заполняем форму регистрации студента
         */
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        $("#firstName").setValue("Aleksandr");
        $("#lastName").setValue("Aleksandrov");
        $("#userEmail").setValue("aleksandrov@aleks.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__day--009:not(.react-datepicker__day--outside-month)").click();
        $(".practice-form-wrapper").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("Wood.jpg");
        $("#currentAddress").setValue("Aleksandrov street");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        /*
          Проверяем полученные результаты после отправки формы
         */
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Student Name Aleksandr Aleksandrov"),
                text("Student Email aleksandrov@aleks.com"),
                text("Gender Male"),
                text("Mobile 0123456789"),
                text("Date of Birth 09 September,1996"),
                text("Subjects Computer Science"),
                text("Hobbies Music"),
                text("Picture Wood.jpg"),
                text("Address Aleksandrov street"),
                text("State and City Haryana Karnal"));
    }
}