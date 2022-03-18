package filehandlers.writefiles;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import entities.Vaccination;
import services.vaccinationorder.VaccinationOrder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteVaccinationOrder {

    private static final List<String> HEADER = Arrays.asList("Időpont", "Név", "Irányítószám", "Életkor", "E-mail cím", "TAJ szám");

    private VaccinationOrder vaccinations;
    private String folderName;

    public WriteVaccinationOrder(VaccinationOrder vaccinations, String folderName) {
        this.vaccinations = vaccinations;
        this.folderName = folderName;
    }

    public void writeFile() {
        try (XSSFWorkbook workbook = new XSSFWorkbook();
             FileOutputStream output = new FileOutputStream(getFileName())) {
            Sheet sheet = workbook.createSheet(vaccinations.getPostalCode());
            createHeader(sheet);
            writeDataToSheet(sheet);
            setColumnWidthAdaptively(sheet);
            workbook.write(output);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file to folder " + folderName + "!", ioe);
        }
    }

    private void setColumnWidthAdaptively(Sheet sheet) {
        for (int i = 0; i < HEADER.size(); i++) {
            sheet.autoSizeColumn(i);
        }
    }

    private void writeDataToSheet(Sheet sheet) {
        int rowCounter = 1;
        for (Vaccination actual : vaccinations.getVaccinations()) {
            Row row = sheet.createRow(rowCounter++);
            createVaccinationRow(actual, row);
        }
    }

    private void createVaccinationRow(Vaccination actual, Row row) {
        Cell dateCell = row.createCell(0);
        dateCell.setCellValue(actual.getVaccinationDateTime());
        setDateCellStyle(row, dateCell);
        row.createCell(1).setCellValue(actual.getClient().getName());
        row.createCell(2).setCellValue(actual.getClient().getPostalCode());
        row.createCell(3).setCellValue(actual.getClient().getAge());
        row.createCell(4).setCellValue(actual.getClient().getEmail());
        row.createCell(5).setCellValue(actual.getClient().getSocialSecurityNumber());
    }

    private void setDateCellStyle(Row row, Cell dateCell) {
        CreationHelper creationHelper = row.getSheet().getWorkbook().getCreationHelper();
        CellStyle dateStyle = row.getSheet().getWorkbook().createCellStyle();
        dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy.MM.dd hh:mm"));
        dateCell.setCellStyle(dateStyle);
    }

    private void createHeader(Sheet sheet) {
        Row row = sheet.createRow(0);
        for (int i = 0; i < HEADER.size(); i++) {
            row.createCell(i).setCellValue(HEADER.get(i));
        }
    }

    private String getFileName() {
        return folderName + "\\oltasbeosztas_" + vaccinations.getPostalCode() + "_" + vaccinations.getDate().toString() + ".xlsx";
    }
}
