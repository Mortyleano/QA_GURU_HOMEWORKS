package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalWidget;
import tests.utils.RandomUtils;

/**
 * Тест проверяет вывод ошибки в форме регистрации студента при отсутствии введенного номера телефона
 */
public class CheckNegativeDataEntryTest extends TestBase {

    @Test
    public void checkingNegativeDataEntryTest() {
        RandomUtils randomUtils = new RandomUtils();
        new RegistrationPage().openRegistrationPage()
                .removeBanner()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setUserGender(randomUtils.userGender)
                .submitRegistrationForm();

        new ModalWidget().modalWindowNotExist();
    }
}