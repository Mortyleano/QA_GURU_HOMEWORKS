package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalWidget {

    private final SelenideElement modalWindow = $(".modal-content");
    private final SelenideElement modalTitle = $("#example-modal-sizes-title-lg");
    private final SelenideElement modalWindowWithResults = $(".table-responsive");

    /**
     * Проверяет результат формы регистрации студента
     */
    public ModalWidget checkResultRegistrationForm(String key, String value) {
        modalWindow.should(appear.because("Не отображается модальное окно"));
        modalTitle.shouldHave(text("Thanks for submitting the form").because("Не отображается заголовок модального окна"));
        modalWindowWithResults.$(byText(key)).parent().shouldHave(text(value).because("Отсутствует введенный параметр"));
        return this;
    }

    /**
     * Проверяет, что модальное окно не появилось после ввода невалидных данных в форму регистрации студента
     */
    public void modalWindowNotExist() {
        modalWindow.shouldNotBe(exist.because("Модальное окно появилось после ввода невалидных данных"));
    }
}