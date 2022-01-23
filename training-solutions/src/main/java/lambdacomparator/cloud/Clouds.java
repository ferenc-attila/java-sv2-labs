package lambdacomparator.cloud;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Clouds {

    public CloudStorage alphabeticallyFirst(List<CloudStorage> storages) {
        List<CloudStorage> alphabetically = new ArrayList<>(storages);
        alphabetically.sort(Comparator.comparing(CloudStorage::getProvider,
                Comparator.comparing(name -> name.trim().toLowerCase())));
        return Optional.of(alphabetically.get(0)).orElseThrow(() -> new IllegalArgumentException("Empty list!"));
    }

    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> storages) {
        List<CloudStorage> bestPrice = new ArrayList<>(storages);
        bestPrice.sort(Comparator.comparing(CloudStorage::getPrice,
                Comparator.nullsFirst(Comparator.naturalOrder())));
        return Optional.of(bestPrice.get(0)).orElseThrow(() -> new IllegalArgumentException("Empty list!"));
    }

    public List<CloudStorage> worstOffers(List<CloudStorage> storages) {
        List<CloudStorage> offers = new ArrayList<>(storages);
        offers.sort(Comparator.reverseOrder());
        return new ArrayList<>(offers.subList(0, Math.min(offers.size(), 3)));
    }
}
