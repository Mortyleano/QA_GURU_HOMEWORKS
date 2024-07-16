package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.RegistrationPage;
import pages.components.ModalWidget;
import tests.utils.RandomUtils;

import static pages.components.ModalWidget.*;

public class CheckMinimalDataEntryTest extends TestBase {

    @Tag("smoke") @Tag("registration")
    @CsvSource(value = {"Ivan, Male", "Anna, Female"})
    @ParameterizedTest(name = "Проверяет минимальный ввод данных в форме регистрации с именем {0} и полом {1}")
    void checkingMinimalDataEntryTest(String userFirstName, String userGender) {
        RandomUtils randomUtils = new RandomUtils();
        new RegistrationPage().openRegistrationPage()
                .removeBanner()
                .setFirstName(userFirstName)
                .setLastName(randomUtils.lastName)
                .setUserGender(userGender)
                .setUserNumber(randomUtils.userNumber)
                .setDateOfBirth(randomUtils.dayOfBirth, randomUtils.monthOfBirth, randomUtils.yearOfBirth)
                .submitRegistrationForm();

        new ModalWidget().checkResultRegistrationForm(MODAL_STUDENT_NAME, userFirstName + " " + randomUtils.lastName)
                .checkResultRegistrationForm(MODAL_STUDENT_GENDER, userGender)
                .checkResultRegistrationForm(MODAL_STUDENT_MOBILE, randomUtils.userNumber)
                .checkResultRegistrationForm(MODAL_STUDENT_DATE_OF_BIRTH, randomUtils.dayOfBirth + " "
                        + randomUtils.monthOfBirth + ","
                        + randomUtils.yearOfBirth
                );
    }
}