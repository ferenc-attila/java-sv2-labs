package filehandlers.writefiles;

import filehandlers.massclientreader.MassClientReaderByExcelXml;
import org.junit.jupiter.api.Test;
import services.registration.Client;
import services.vaccinationorder.VaccinationOrder;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WriteVaccinationOrderTest {

    @Test
    void writeFileTest() {
        MassClientReaderByExcelXml massClientReaderByExcelXml = new MassClientReaderByExcelXml("src/test/resources/mock_data.xlsx", true);
        List<Client> clients = massClientReaderByExcelXml.readFile();
        VaccinationOrder order = new VaccinationOrder("3300", LocalDate.of(2022, 2, 14), clients);
        WriteVaccinationOrder writeOrder = new WriteVaccinationOrder(order, ".");
        writeOrder.writeFile();
    }
}