package services.registration.massclientreader;

import services.registration.massclientreader.MassClientReaderByExcelXml;
import org.junit.jupiter.api.Test;
import services.registration.Client;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MassClientReaderByExcelXmlTest {

    MassClientReaderByExcelXml massClientReaderByExcelXml;

    @Test
    void readFile() {
        massClientReaderByExcelXml = new MassClientReaderByExcelXml("src/test/resources/MOCK_DATA.xlsx", true);
        List<Client> clients = massClientReaderByExcelXml.readFile();
        assertEquals(1000, clients.size());
        assertEquals("Kylila Mattholie", clients.get(0).getName());
        assertEquals("8488", clients.get(298).getPostalCode());
        assertEquals(91, clients.get(498).getAge());
        assertEquals("kgianettinije@sciencedirect.com", clients.get(698).getEmail());
        assertEquals("123456788", clients.get(999).getSocialSecurityNumber());
    }

    @Test
    void readUnreachableFile() {
        massClientReaderByExcelXml = new MassClientReaderByExcelXml("src/test/resources/UNREACHABLE_DATA.xlsx", true);
        IllegalStateException ise = assertThrows(IllegalStateException.class,
                () -> massClientReaderByExcelXml.readFile());
        assertEquals(FileNotFoundException.class, ise.getCause().getClass());
        assertEquals("Cannot read file: src/test/resources/UNREACHABLE_DATA.xlsx!", ise.getMessage());
    }

    @Test
    void emptyFileNameTest() {
        IllegalStateException ise = assertThrows(IllegalStateException.class,
                () -> new MassClientReaderByExcelXml("", true));
        assertEquals("Invalid or empty filename: !", ise.getMessage());
    }

    @Test
    void shortFileNameTest() {
        IllegalStateException ise = assertThrows(IllegalStateException.class,
                () -> new MassClientReaderByExcelXml("a.xls", true));
        assertEquals("Invalid or empty filename: a.xls!", ise.getMessage());
    }

    @Test
    void invalidExtensionTest() {
        IllegalStateException ise = assertThrows(IllegalStateException.class,
                () -> new MassClientReaderByExcelXml("data.xls", true));
        assertEquals("Invalid or empty filename: data.xls!", ise.getMessage());
    }

    @Test
    void invalidAgeInExcelTest() {
        massClientReaderByExcelXml = new MassClientReaderByExcelXml("src/test/resources/invalid_data.xlsx", true);
        IllegalArgumentException ise = assertThrows(IllegalArgumentException.class,
                () -> massClientReaderByExcelXml.readFile());
        assertEquals(IllegalStateException.class, ise.getCause().getClass());
        assertEquals("Cannot parse an age value from the table!", ise.getMessage());
    }
}