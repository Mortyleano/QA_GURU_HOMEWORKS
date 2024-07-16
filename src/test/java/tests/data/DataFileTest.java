package tests.data;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataFileTest {

    private final ClassLoader classLoader = DataFileTest.class.getClassLoader();

    public void checkZipFileParsing(
            String archiveName,
            String pdfText,
            Integer csvIndex,
            String[] checkCsvValue,
            Integer xlsSheetIndex,
            Integer xlsRowIndex,
            Integer xlsCellIndex,
            String xlsValue
    ) throws Exception {
        try (ZipInputStream zipInputStream = new ZipInputStream(Objects.requireNonNull(classLoader.getResourceAsStream(archiveName)))) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (zipEntry.getName().contains("__MACOSX") || zipEntry.getName().contains("/.DS_Store")) {
                    continue;
                }
                if (zipEntry.getName().contains(".pdf")) {
                    PDF pdfFile = new PDF(zipInputStream);
                    assertThat(pdfFile.text.contains(pdfText)).isTrue();
                }
                if (zipEntry.getName().contains(".csv")) {
                    CSVReader csvFile = new CSVReader(new InputStreamReader(zipInputStream));
                    List<String[]> data = csvFile.readAll();
                    assertThat(data.get(csvIndex)).isEqualTo(checkCsvValue);
                }
                if (zipEntry.getName().contains(".xls")) {
                    XLS xlsFile = new XLS(zipInputStream);
                    String xls = xlsFile.excel
                            .getSheetAt(xlsSheetIndex)
                            .getRow(xlsRowIndex)
                            .getCell(xlsCellIndex)
                            .getStringCellValue();
                    assertTrue(xls.contains(xlsValue));
                }
            }
        }
    }

    public void checkJsonFileParsing(String jsonFileName, Integer jsonIndex, String jsonValue) throws Exception {
        try (InputStream inputStream = classLoader.getResourceAsStream(jsonFileName)) {
            ObjectMapper objectMapper = new ObjectMapper();
            StarWarsKey starWarsKey = objectMapper.readValue(inputStream, StarWarsKey.class);
            assertThat(starWarsKey.getCharacters().get(jsonIndex).getName().contains(jsonValue)).isTrue();
        }
    }
}