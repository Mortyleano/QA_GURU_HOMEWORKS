package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.TextBoxPage;
import tests.utils.RandomUtils;

import java.util.stream.Stream;

public class CheckTextBoxTest extends TestBase {

    @Tag("smoke")
    @MethodSource
    @ParameterizedTest(name = "Тест проверяет заполнение обычных текстовых форм и получение результатов отправки")
    void checkingTextBoxTest(String fullName, String userEmail, String currentAddress, String permanentAddress) {
        new TextBoxPage().openTextBoxPage()
                .removeBanner()
                .setFullName(fullName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submitTextBoxForm()
                .checkResultOutputBox(fullName, userEmail, currentAddress, permanentAddress);
    }

    static Stream<Arguments> checkingTextBoxTest() {
        RandomUtils randomUtils = new RandomUtils();
        return Stream.of(
                Arguments.of(
                        randomUtils.fullName,
                        randomUtils.userEmail,
                        randomUtils.userCurrentAddress,
                        randomUtils.userPermanentAddress)
        );
    }
}