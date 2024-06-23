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

    public TextBoxPage openTextBoxPage() {
        open("/text-box");
        titlePage.shouldHave(text("Text Box"));
        return this;
    }

    public TextBoxPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName(String fullName) {
        fullNameInput.shouldBe(visible).setValue(fullName);
        return this;
    }

    public TextBoxPage setUserEmail(String userEmail) {
        userEmailInput.shouldBe(visible).setValue(userEmail);
        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        currentAddressInput.shouldBe(visible).setValue(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress) {
        permanentAddressInput.shouldBe(visible).setValue(permanentAddress);
        return this;
    }

    public TextBoxPage submitTextBoxForm() {
        submitButton.shouldBe(visible).click();
        return this;
    }

    public void checkResultOutputBox(String fullName, String email, String currentAddress, String permanentAddress) {
        outputName.shouldHave(text(fullName));
        outputEmail.shouldHave(text(email));
        outputCurrentAddress.shouldHave(text(currentAddress));
        outputPermanentAddress.shouldHave(text(permanentAddress));
    }
}