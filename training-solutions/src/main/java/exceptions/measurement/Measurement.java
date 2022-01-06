package exceptions.measurement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Measurement {

    public List<String> readFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Unable to read \"" + path + "\" file!", ioe);
        }
    }

    public List<String> validate(List<String> fileContent) {
        List<String> errors = new ArrayList<>();
        for (String row : fileContent) {
            StringBuilder errorDescription = new StringBuilder();
            String[] data = row.split(",");
            checkRowLength(errorDescription, data);
            checkRowId(errorDescription, data);
            checkMeasurement(errorDescription, data);
            checkName(errorDescription, data);
            createRowInErrorsList(errors, row, errorDescription);
        }
        return errors;
    }

    private void checkRowLength(StringBuilder errorDescription, String[] data) {
        if (data.length != 3) {
            addErrorDescriptionDelimiter(errorDescription);
            addErrorDescription(errorDescription, Integer.toString(data.length), " is invalid amount of cells!");
        }
    }

    private void checkRowId(StringBuilder errorDescription, String[] data) {
        if (data.length >= 1) {
            try {
                Integer.parseInt(data[0]);
            } catch (NumberFormatException | NullPointerException exception) {
                addErrorDescription(errorDescription, data[0], " is an invalid row id!");
            }
        }
    }

    private void checkMeasurement(StringBuilder errorDescription, String[] data) {
        if (data.length >= 2) {
            try {
                Double.parseDouble(data[1]);
            } catch (NumberFormatException | NullPointerException exception) {
                addErrorDescriptionDelimiter(errorDescription);
                addErrorDescription(errorDescription, data[1], " is an invalid measurement value!");
            }
        }
    }

    private void checkName(StringBuilder errorDescription, String[] data) {
        if (data.length >= 3) {
            String name = data[2];
            if (name.isBlank() || !(name.strip().contains(" "))) {
                addErrorDescriptionDelimiter(errorDescription);
                addErrorDescription(errorDescription, data[2], " is an invalid name!");
            }
        }
    }

    private void addErrorDescription(StringBuilder errorDescription, String data, String message) {
        errorDescription.append(data).append(message);
    }

    private void addErrorDescriptionDelimiter(StringBuilder errorDescription) {
        if (!errorDescription.isEmpty()) {
            errorDescription.append("; ");
        }
    }

    private void createRowInErrorsList(List<String> errors, String row, StringBuilder errorDescription) {
        if (!errorDescription.isEmpty()) {
            String error = row + ", " + errorDescription;
            errors.add(error);
        }
    }
}

