package services.registration.massclientreader;

import services.registration.Client;

import java.util.List;

public interface MassClientReaderByFile {

    List<Client> readFile();
}
