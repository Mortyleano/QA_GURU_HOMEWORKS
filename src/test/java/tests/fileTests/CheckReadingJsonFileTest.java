package tests.fileTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.data.DataFileTest;

public class CheckReadingJsonFileTest {

    public String jsonFileName = "files/starwars.json";
    public Integer jsonIndex = 0;
    public String jsonValue = "Luke Skywalker";

    @Test
    @Tag("files")
    @DisplayName("Тест проверяет чтение JSON файла и проверку содержимого из него")
    void checkingReadingJsonFileTest() throws Exception {
        new DataFileTest().checkJsonFileParsing(jsonFileName, jsonIndex, jsonValue);
    }
}