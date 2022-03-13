package readtable.excel;

import registration.Client;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public List<Client> readFile() {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            return readSheet(sheet);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file: " + file + "!", ioe);
        }
    }

    private List<Client> readSheet(Sheet sheet) {
        List<Client> clients = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            clients.add(createClients(rowIterator.next()));
        }
        return clients;
    }

    private Client createClients(Row row) {
        Iterator<Cell> cellIterator = row.cellIterator();
        try {
            return new Client(cellIterator.next().getStringCellValue(),
                    cellIterator.next().getStringCellValue(),
                    Integer.parseInt(cellIterator.next().getStringCellValue()),
                    cellIterator.next().getStringCellValue(),
                    cellIterator.next().getStringCellValue());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Invalid age value in the table!", nfe);
        }
    }

    public String getFile() {
        return file;
    }
}
