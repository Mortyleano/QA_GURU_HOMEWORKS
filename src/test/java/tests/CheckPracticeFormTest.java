package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        $(".react-datepicker__month-select").selectOptionByValue("9");
        $(".react-datepicker__year-select").selectOptionByValue("1996");
        $(".react-datepicker__day--009").click();
        $(".practice-form-wrapper").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("Wood.jpg");
        $("#stateCity-wrapper").scrollTo();
        $("#currentAddress").setValue("Aleksandrov street");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        /*
          Проверяем полученные результаты после отправки формы
         */
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                Condition.text("Student Name Aleksandr Aleksandrov"),
                Condition.text("Student Email aleksandrov@aleks.com"),
                Condition.text("Gender Male"),
                Condition.text("Mobile 0123456789"),
                Condition.text("Date of Birth 09 October,1996"),
                Condition.text("Subjects Computer Science"),
                Condition.text("Hobbies Music"),
                Condition.text("Picture Wood.jpg"),
                Condition.text("Address Aleksandrov street"),
                Condition.text("State and City Haryana Karnal"));
    }
}