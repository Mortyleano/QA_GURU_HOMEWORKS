package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.Base;
import pages.RegistrationPage;
import pages.components.ModalWidget;

import static pages.RegistrationPage.Gender.Female;

/**
 * Тест проверяет минимальное количество введенных данных в форме регистрации
 */
public class CheckMinimalDataEntryTest extends Base {

    @Test
    public void checkingMinimalDataEntryTest() {
        new RegistrationPage().openRegistrationPage()
                .setFirstName("Aleksandra")
                .setLastName("Aleksandrova")
                .setUserGender(Female)
                .setUserNumber("0123456789")
                .setDateOfBirth("9", "April", "1996")
                .submitRegistrationForm();

        new ModalWidget().checkResultRegistrationForm("Student Name", "Aleksandra Aleksandrova")
                .checkResultRegistrationForm("Gender", "Female")
                .checkResultRegistrationForm("Mobile", "0123456789")
                .checkResultRegistrationForm("Date of Birth", "09 April,1996");
    }
}