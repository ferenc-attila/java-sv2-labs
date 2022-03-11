package readtable.excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelXml {

    private String file;

    public ReadExcelXml(String file) {
        validateFileName(file);
        this.file = file;
    }

    private void validateFileName(String file) {
        if (file == null || file.length() < 6 || !file.endsWith(".xlsx")) {
            throw new IllegalArgumentException("Invalid filename: " + file);
        }
    }

    public void readFile() {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file: " + file);
        }
    }

    public String getFile() {
        return file;
    }
}
