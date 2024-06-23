package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.Base;
import pages.RegistrationPage;
import pages.components.ModalWidget;

import static pages.RegistrationPage.Gender.Other;

/**
 * Тест проверяет ввод невалидных данных в форме регистрации студента
 */
public class CheckNegativeDataEntryTest extends Base {

    @Test
    public void checkingNegativeDataEntryTest() {
        new RegistrationPage().openRegistrationPage()
                .setFirstName("Nobody")
                .setLastName("Nothing")
                .setUserGender(Other)
                .setUserNumber("012345678")
                .submitRegistrationForm();

        new ModalWidget().modalWindowNotExist();
    }
}