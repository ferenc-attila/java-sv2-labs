package filehandlers.massclientreader;

import entities.Client;

import java.util.List;

public interface MassClientReaderByFile {

    List<Client> readFile();
}
