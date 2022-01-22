package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BucketList {

    private List<Destination> destinations = new ArrayList<>();

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public List<Destination> getDestinations() {
        return List.copyOf(destinations);
    }

    public Optional<Destination> getDestinationWithKeyword(String keyword) {
        Optional<Destination> destinationWithKeyWord = Optional.empty();
        for (Destination actual : destinations) {
            if (actual.getDescription().contains(keyword)) {
                return Optional.of(actual);
            }
        }
        return destinationWithKeyWord;
    }

    public Optional<Destination> getDestinationNearerThanGiven(int km) {
        Optional<Destination> destinationNearerThanGiven = Optional.empty();
        for (Destination actual : destinations) {
            if (actual.getKmFromHome() < km) {
                return Optional.of(actual);
            }
        }
        return destinationNearerThanGiven;
    }
}
