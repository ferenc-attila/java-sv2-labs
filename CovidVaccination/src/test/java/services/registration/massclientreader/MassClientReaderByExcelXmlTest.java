package services.registration.massclientreader;

import org.junit.jupiter.api.Test;
import services.registration.Client;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MassClientReaderByExcelXmlTest {

    MassClientReaderByExcelXml massClientReaderByExcelXml;

    @Test
    void readFileTest() {
        massClientReaderByExcelXml = new MassClientReaderByExcelXml("src/test/resources/mock_data.xlsx", true);
        List<Client> clients = massClientReaderByExcelXml.readFile();
        assertEquals(100, clients.size());
        assertEquals("Kylila Mattholie", clients.get(0).getName());
        assertEquals("3300", clients.get(28).getPostalCode());
        assertEquals(75, clients.get(48).getAge());
        assertEquals("amckernon1w@vistaprint.com", clients.get(68).getEmail());
        assertEquals("123456788", clients.get(99).getSocialSecurityNumber());
    }

    @Test
    void readFileWithoutHeaderTest() {
        massClientReaderByExcelXml = new MassClientReaderByExcelXml("src/test/resources/headerless.xlsx", false);
        List<Client> clients = massClientReaderByExcelXml.readFile();
        assertEquals(100, clients.size());
        assertEquals("Kylila Mattholie", clients.get(0).getName());
        assertEquals("3300", clients.get(28).getPostalCode());
        assertEquals(75, clients.get(48).getAge());
        assertEquals("amckernon1w@vistaprint.com", clients.get(68).getEmail());
        assertEquals("123456788", clients.get(99).getSocialSecurityNumber());
    }

    @Test
    void readUnreachableFileTest() {
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