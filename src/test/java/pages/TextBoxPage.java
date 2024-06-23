package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    private final SelenideElement titlePage = $(".text-center");
    private final SelenideElement fullNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement outputName = $("#output #name");
    private final SelenideElement outputEmail = $("#output #email");
    private final SelenideElement outputCurrentAddress = $("#output #currentAddress");
    private final SelenideElement outputPermanentAddress = $("#output #permanentAddress");

    /**
     * Открывает страницу с обычными текстовыми формами
     */
    public TextBoxPage openTextBoxPage() {
        open("/text-box");
        titlePage.shouldHave(text("Text Box").because("Не отображается заголовок страницы"));
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this;
    }


    /**
     * Устанавливает полное имя пользователя в поле ввода
     */
    public TextBoxPage setFullName(String fullName) {
        fullNameInput.shouldBe(visible.because("Отсуствует поле ввода для полного имени")).setValue(fullName);
        return this;
    }

    /**
     * Устанавливает электронную почту пользователя в поле ввода
     */
    public TextBoxPage setUserEmail(String userEmail) {
        userEmailInput.shouldBe(visible.because("Отсуствует поле ввода для эл.почты пользователя")).setValue(userEmail);
        return this;
    }

    /**
     * Устанавливает текущий адрес пользователя в поле ввода
     */
    public TextBoxPage setCurrentAddress(String currentAddress) {
        currentAddressInput.shouldBe(visible.because("Отсуствует поле ввода текущего адреса")).setValue(currentAddress);
        return this;
    }

    /**
     * Устанавливает постоянный адрес пользователя в поле ввода
     */
    public TextBoxPage setPermanentAddress(String permanentAddress) {
        permanentAddressInput.shouldBe(visible.because("Отсуствует поле ввода постоянного адреса")).setValue(permanentAddress);
        return this;
    }

    /**
     * Подтверждает и отправляет данные в блок вывода
     */
    public TextBoxPage submitTextBoxForm() {
        submitButton.shouldBe(visible.because("Отсутствует кнопка для отправки данных")).click();
        return this;
    }

    /**
     * Проверяет полученные данные после подтверждения
     */
    public void checkResultOutputBox(String fullName, String email, String currentAddress, String permanentAddress) {
        outputName.shouldHave(text(fullName).because("Отсутствует введенное имя пользователя"));
        outputEmail.shouldHave(text(email).because("Отсутствует введенная эл.почта пользователя"));
        outputCurrentAddress.shouldHave(text(currentAddress).because("Отсутствует введенный текущий адрес пользователя"));
        outputPermanentAddress.shouldHave(text(permanentAddress).because("Отсутствует введенный постоянный адрес пользователя"));
    }
}