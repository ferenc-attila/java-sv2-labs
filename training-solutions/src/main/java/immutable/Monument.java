package immutable;

import java.time.LocalDate;

public class Monument {

    private final String name;
    private final String address;
    private final LocalDate dateOfRegistry;
    private final String registryNumber;

    public Monument(String name, String address, LocalDate dateOfRegistry, String registryNumber) {
        IllegalArgumentException exception = new IllegalArgumentException("Name, address or registry number cannot be empty!");
        if (!isEmpty(name)) {
            this.name = name;
        } else {
            throw exception;
        }
        if (!isEmpty(address)) {
            this.address = address;
        } else {
            throw exception;
        }
        if (!isEmpty(dateOfRegistry.toString())) {
            this.dateOfRegistry = dateOfRegistry;
        } else {
            throw exception;
        }
        if (!isEmpty(registryNumber)) {
            this.registryNumber = registryNumber;
        } else {
            throw exception;
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDateOfRegistry() {
        return dateOfRegistry;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }

    private boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }
}
