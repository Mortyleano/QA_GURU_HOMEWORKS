package tests.demoqa;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

/**
 * Тест проверяет заполнение обычных текстовых форм и получение результатов отправки
 */
public class CheckTextBoxTest extends TestBase {

    @Test
    public void checkingTextBoxTest() {
        new TextBoxPage().openTextBoxPage()
                .removeBanner()
                .setFullName("Aleksandr Aleksandrov")
                .setUserEmail("aleks@aleks.ru")
                .setCurrentAddress("Aleksandrov Street")
                .setPermanentAddress("QA street")
                .submitTextBoxForm()
                .checkResultOutputBox(
                        "Aleksandr Aleksandrov",
                        "aleks@aleks.ru",
                        "Aleksandrov Street",
                        "QA street");
    }
}