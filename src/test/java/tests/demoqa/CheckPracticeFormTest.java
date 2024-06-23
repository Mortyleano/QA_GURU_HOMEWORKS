package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalWidget;

import static pages.RegistrationPage.Gender.Male;

/**
 * Тест проверяет заполнение формы регистрации студента и получение результатов отправки
 */
public class CheckPracticeFormTest extends TestBase {

    @Test
    public void checkingPracticeFormTest() {
        new RegistrationPage().openRegistrationPage()
                .removeBanner()
                .setFirstName("Aleksandr")
                .setLastName("Aleksandrov")
                .setUserEmail("aleksandrov@aleks.com")
                .setUserGender(Male)
                .setUserNumber("0123456789")
                .setDateOfBirth("9", "April", "1996")
                .setSubject("Computer Science")
                .setHobby("Music")
                .uploadPictureFile("Wood.jpg")
                .setCurrentAddress("Aleksandrov street")
                .setState("Haryana")
                .setCity("Karnal")
                .submitRegistrationForm();

        new ModalWidget().checkResultRegistrationForm("Student Name", "Aleksandr Aleksandrov")
                .checkResultRegistrationForm("Student Email", "aleksandrov@aleks.com")
                .checkResultRegistrationForm("Gender", "Male")
                .checkResultRegistrationForm("Mobile", "0123456789")
                .checkResultRegistrationForm("Date of Birth", "09 April,1996")
                .checkResultRegistrationForm("Subjects", "Computer Science")
                .checkResultRegistrationForm("Hobbies", "Music")
                .checkResultRegistrationForm("Picture", "Wood.jpg")
                .checkResultRegistrationForm("Address", "Aleksandrov street")
                .checkResultRegistrationForm("State and City", "Haryana Karnal");
    }
}