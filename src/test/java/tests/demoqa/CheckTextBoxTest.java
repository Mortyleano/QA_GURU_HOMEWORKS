package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import tests.utils.RandomUtils;

/**
 * Тест проверяет заполнение обычных текстовых форм и получение результатов отправки
 */
public class CheckTextBoxTest extends TestBase {

    @Test
    public void checkingTextBoxTest() {
        RandomUtils randomUtils = new RandomUtils();
        new TextBoxPage().openTextBoxPage()
                .removeBanner()
                .setFullName(randomUtils.fullName)
                .setUserEmail(randomUtils.userEmail)
                .setCurrentAddress(randomUtils.userCurrentAddress)
                .setPermanentAddress(randomUtils.userPermanentAddress)
                .submitTextBoxForm()
                .checkResultOutputBox(
                        randomUtils.fullName,
                        randomUtils.userEmail,
                        randomUtils.userCurrentAddress,
                        randomUtils.userPermanentAddress);
    }
}