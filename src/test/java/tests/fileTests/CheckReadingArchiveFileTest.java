package tests.fileTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.data.DataFileTest;

public class CheckReadingArchiveFileTest {

    public static final String ARCHIVE_PATH = "files/archive.zip";
    public static final String PDF_TEXT = "Aleksandr";
    public static final String XLS_VALUE = "Aleksandr";
    public static String[] CSV_VALUE = {"Game Number", "Game Length"};
    public static Integer csvIndex = 0;
    public static Integer xlsSheetIndex = 0;
    public static Integer xlsRowIndex = 1;
    public static Integer xlsCellIndex = 0;

    @Test
    @Tag("files")
    @DisplayName("Тест проверяет чтение zip архива и проверку содержимого каждого файла из него")
    void checkingReadingArchiveFileTest() throws Exception {
        new DataFileTest().checkZipFileParsing(
                ARCHIVE_PATH, PDF_TEXT, csvIndex,
                CSV_VALUE, xlsSheetIndex, xlsRowIndex,
                xlsCellIndex, XLS_VALUE
        );
    }
}