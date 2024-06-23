package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarWidget;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement practiceFormWrapper = $(".practice-form-wrapper");
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement hobbyWrapper = $("#hobbiesWrapper");
    private final SelenideElement uploadPictureButton = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement stateAndCityWrapper = $("#stateCity-wrapper");
    private final SelenideElement submitButton = $("#submit");

    public RegistrationPage openRegistrationPage() {
        open("/automation-practice-form");
        practiceFormWrapper.shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.shouldBe(visible).setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.shouldBe(visible).setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.shouldBe(visible).setValue(userEmail);
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.shouldBe(visible).setValue(userNumber);
        return this;
    }

    public RegistrationPage setUserGender(String userGender) {
        genderWrapper.shouldBe(visible).$(byText(userGender)).click();
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.shouldBe(visible).click();
        new CalendarWidget().setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectInput.shouldBe(visible).setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbyWrapper.shouldBe(visible).$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPictureFile(String fileName) {
        uploadPictureButton.shouldBe(visible).uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.shouldBe(visible).setValue(currentAddress);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.click();
        stateAndCityWrapper.shouldHave(text(state)).$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.click();
        stateAndCityWrapper.shouldHave(text(city)).$(byText(city)).click();
        return this;
    }

    public void submitRegistrationForm() {
        submitButton.shouldBe(visible).click();
    }
}