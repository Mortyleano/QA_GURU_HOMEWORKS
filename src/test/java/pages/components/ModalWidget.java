package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalWidget {

    private final SelenideElement modalWindow = $(".modal-content");
    private final SelenideElement modalTitle = $("#example-modal-sizes-title-lg");
    private final SelenideElement modalWindowWithResults = $(".table-responsive");

    public ModalWidget checkResultRegistrationForm(String key, String value) {
        modalWindow.should(appear);
        modalTitle.shouldHave(text("Thanks for submitting the form"));
        modalWindowWithResults.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public void modalWindowNotExist() {
        modalWindow.shouldNotBe(exist);
    }
}