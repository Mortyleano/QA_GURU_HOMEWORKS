package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalWidget;
import tests.utils.RandomUtils;

import static pages.components.ModalWidget.*;

/**
 * Тест проверяет минимальное количество введенных данных в форме регистрации
 */
public class CheckMinimalDataEntryTest extends TestBase {

    @Test
    public void checkingMinimalDataEntryTest() {
        RandomUtils randomUtils = new RandomUtils();
        new RegistrationPage().openRegistrationPage()
                .removeBanner()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setUserGender(randomUtils.userGender)
                .setUserNumber(randomUtils.userNumber)
                .setDateOfBirth(randomUtils.dayOfBirth, randomUtils.monthOfBirth, randomUtils.yearOfBirth)
                .submitRegistrationForm();

        new ModalWidget().checkResultRegistrationForm(MODAL_STUDENT_NAME, randomUtils.firstName + " " + randomUtils.lastName)
                .checkResultRegistrationForm(MODAL_STUDENT_GENDER, randomUtils.userGender)
                .checkResultRegistrationForm(MODAL_STUDENT_MOBILE, randomUtils.userNumber)
                .checkResultRegistrationForm(MODAL_STUDENT_DATE_OF_BIRTH, randomUtils.dayOfBirth + " "
                        + randomUtils.monthOfBirth + ","
                        + randomUtils.yearOfBirth
                );
    }
}