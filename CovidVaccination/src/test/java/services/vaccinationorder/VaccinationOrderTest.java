package services.vaccinationorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entities.Client;
import filehandlers.massclientreader.MassClientReaderByExcelXml;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationOrderTest {

    MassClientReaderByExcelXml massClientReaderByExcelXml;
    List<Client> clients;

    @BeforeEach
    void init() {
        massClientReaderByExcelXml = new MassClientReaderByExcelXml("src/test/resources/mock_data.xlsx", true);
        clients = massClientReaderByExcelXml.readFile();
    }

    @Test
    void createTest() {
        VaccinationOrder order = new VaccinationOrder("3300", LocalDate.of(2022, 2, 14), clients);
        assertEquals(16, order.getVaccinations().size());
        assertEquals("Kylila Mattholie", order.getVaccinations().get(0).getClient().getName());
        assertEquals("gannesliee@hexun.com", order.getVaccinations().get(15).getClient().getEmail());
        assertEquals("3300", order.getVaccinations().get(10).getClient().getPostalCode());
    }
}