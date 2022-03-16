package filehandlers.massclientreader;

import services.registration.Client;
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

public class MassClientReaderByExcelXml implements MassClientReaderByFile {

    private String file;
    private boolean header;

    public MassClientReaderByExcelXml(String file, boolean header) {
        validateFileName(file);
        this.file = file;
        this.header = header;
    }

    private void validateFileName(String file) {
        if (file == null || file.length() < 6 || !file.endsWith(".xlsx")) {
            throw new IllegalStateException("Invalid or empty filename: " + file + "!");
        }
    }

    public List<Client> readFile() {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            return readSheet(sheet);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file: " + file + "!", ioe);
        }
    }

    private List<Client> readSheet(Sheet sheet) {
        List<Client> clients = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.rowIterator();
        if (header) {
            rowIterator.next();
        }
        while (rowIterator.hasNext()) {
            clients.add(createClients(rowIterator.next()));
        }
        return clients;
    }

    private Client createClients(Row row) {
        Iterator<Cell> cellIterator = row.cellIterator();
        try {
            return new Client(getStringValue(cellIterator),
                    getPostalCode(cellIterator),
                    getAge(cellIterator),
                    getStringValue(cellIterator),
                    getSocialSecurityNumber(cellIterator));
        } catch (IllegalStateException ise) {
            throw new IllegalArgumentException("Cannot parse an age value from the table!", ise);
        }
    }

    private String getStringValue(Iterator<Cell> cellIterator) {
        return cellIterator.next().getStringCellValue();
    }

    private String getPostalCode(Iterator<Cell> cellIterator) {
        Double value = cellIterator.next().getNumericCellValue();
        int postalCode = value.intValue();
        return Integer.toString(postalCode);
    }

    private int getAge(Iterator<Cell> cellIterator) {
        Double age = cellIterator.next().getNumericCellValue();
        return age.intValue();
    }

    private String getSocialSecurityNumber(Iterator<Cell> cellIterator) {
        String socialSecurityNumber = cellIterator.next().getStringCellValue();
        return socialSecurityNumber.replace("-", "");
    }
}
