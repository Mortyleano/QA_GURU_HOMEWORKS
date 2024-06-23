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

    public enum Gender {
        Male,
        Female,
        Other
    }

    /**
     * Открывает страницу регистрации студента и закрывает все баннеры на ней
     */
    public RegistrationPage openRegistrationPage() {
        open("/automation-practice-form");
        practiceFormWrapper.shouldHave(text("Student Registration Form").because("Не открылся сайт"));
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this;
    }

    /**
     * Устанавливает имя студента в поле ввода
     */
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.shouldBe(visible.because("Отсуствует поле ввода для имени студента")).setValue(firstName);
        return this;
    }

    /**
     * Устанавливает фамилию студента в поле ввода
     */
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.shouldBe(visible.because("Отсуствует поле ввода для фамилии студента")).setValue(lastName);
        return this;
    }

    /**
     * Устанавливает электронную почту студента в поле ввода
     */
    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.shouldBe(visible.because("Отсуствует поле ввода для эл.почты студента")).setValue(userEmail);
        return this;
    }

    /**
     * Устанавливает номер телефона студента в поле ввода
     */
    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.shouldBe(visible.because("Отсуствует поле ввода для номера телефона студента")).setValue(userNumber);
        return this;
    }

    /**
     * Выбирает гендер студента
     */
    public RegistrationPage setUserGender(Gender userGender) {
        genderWrapper
                .shouldBe(visible.because("Отсуствует радио-кнопка для выбора гендера"))
                .$(byText(userGender.toString())).click();
        return this;
    }

    /**
     * Выбирает дату рождения студента в календаре
     */
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.shouldBe(visible.because("Отсуствует календарь для выбора даты рождения студента")).click();
        new CalendarWidget().setDate(day, month, year);
        return this;
    }

    /**
     * Выбирает предмет изучения студента
     */
    public RegistrationPage setSubject(String subject) {
        subjectInput.shouldBe(visible.because("Отсуствует поле предмета изучения для выбора")).setValue(subject).pressEnter();
        return this;
    }

    /**
     * Выбирает хобби студента
     */
    public RegistrationPage setHobby(String hobby) {
        hobbyWrapper.shouldBe(visible.because("Отсуствует хобби для выбора")).$(byText(hobby)).click();
        return this;
    }

    /**
     * Загружает файл с картинкой
     */
    public RegistrationPage uploadPictureFile(String fileName) {
        uploadPictureButton.shouldBe(visible.because("Отсуствует кнопка загрузки картинки")).uploadFromClasspath(fileName);
        return this;
    }

    /**
     * Устанавливает текущий адрес студента в поле ввода
     */
    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.shouldBe(visible.because("Отсуствует поле ввода текущего адреса")).setValue(currentAddress);
        return this;
    }

    /**
     * Устанавливает текущий штат, где проживает студент
     */
    public RegistrationPage setState(String state) {
        stateInput.click();
        stateAndCityWrapper.shouldHave(text(state).because("В списке отсутствует выбранный штат")).$(byText(state)).click();
        return this;
    }

    /**
     * Устанавливает текущий город, где проживает студент
     */
    public RegistrationPage setCity(String city) {
        cityInput.click();
        stateAndCityWrapper.shouldHave(text(city).because("В списке отсутствует выбранный город")).$(byText(city)).click();
        return this;
    }

    /**
     * Подтверждает и отправляет заполненную форму регистрации студента
     */
    public void submitRegistrationForm() {
        submitButton.shouldBe(visible.because("Отсутствует кнопка для подтверждения регистрации")).click();
    }
}