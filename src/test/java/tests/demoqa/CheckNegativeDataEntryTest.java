package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalWidget;

import static pages.RegistrationPage.Gender.Other;

/**
 * Тест проверяет ввод невалидных данных в форме регистрации студента
 */
public class CheckNegativeDataEntryTest extends TestBase {

    @Test
    public void checkingNegativeDataEntryTest() {
        new RegistrationPage().openRegistrationPage()
                .removeBanner()
                .setFirstName("Nobody")
                .setLastName("Nothing")
                .setUserGender(Other)
                .setUserNumber("012345678")
                .submitRegistrationForm();

        new ModalWidget().modalWindowNotExist();
    }
}