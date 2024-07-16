package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.RegistrationPage;
import pages.components.ModalWidget;
import tests.utils.RandomUtils;

import static pages.components.ModalWidget.*;

public class CheckPracticeFormTest extends TestBase {

    @Tag("smoke") @Tag("registration")
    @ValueSource(strings = {"9091112233", "9092223344"})
    @ParameterizedTest(name = "Тест проверяет заполнение формы регистрации студента с моб.номером {0}")
    void checkingPracticeFormTest(String userNumber) {
        RandomUtils randomUtils = new RandomUtils();
        new RegistrationPage().openRegistrationPage()
                .removeBanner()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setUserEmail(randomUtils.userEmail)
                .setUserGender(randomUtils.userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(randomUtils.dayOfBirth, randomUtils.monthOfBirth, randomUtils.yearOfBirth)
                .setSubject(randomUtils.userSubject)
                .setHobby(randomUtils.userHobby)
                .uploadPictureFile(randomUtils.userFile)
                .setCurrentAddress(randomUtils.userCurrentAddress)
                .setState(randomUtils.state)
                .setCity(randomUtils.city)
                .submitRegistrationForm();

        new ModalWidget().checkResultRegistrationForm(MODAL_STUDENT_NAME, randomUtils.firstName + " " + randomUtils.lastName)
                .checkResultRegistrationForm(MODAL_STUDENT_EMAIL, randomUtils.userEmail)
                .checkResultRegistrationForm(MODAL_STUDENT_GENDER, randomUtils.userGender)
                .checkResultRegistrationForm(MODAL_STUDENT_MOBILE, userNumber)
                .checkResultRegistrationForm(MODAL_STUDENT_DATE_OF_BIRTH, randomUtils.dayOfBirth + " "
                        + randomUtils.monthOfBirth + ","
                        + randomUtils.yearOfBirth
                )
                .checkResultRegistrationForm(MODAL_STUDENT_SUBJECT, randomUtils.userSubject)
                .checkResultRegistrationForm(MODAL_STUDENT_HOBBIES, randomUtils.userHobby)
                .checkResultRegistrationForm(MODAL_STUDENT_PICTURE, randomUtils.userFile)
                .checkResultRegistrationForm(MODAL_STUDENT_ADDRESS, randomUtils.userCurrentAddress)
                .checkResultRegistrationForm(MODAL_STUDENT_STATE_AND_CITY, randomUtils.state + " " + randomUtils.city);
    }
}