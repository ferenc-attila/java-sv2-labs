package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {

    private final List<Feature> features;
    private final int price;
    private final String registrationNumber;

    public CatalogItem(String registrationNumber, int price, Feature... features) {
        this.features = Arrays.asList(features);
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public int fullLengthAtOneItem() {
        int fullLength = 0;
        for (Feature actual : features) {
            if (isAudioFeature(actual)) {
                fullLength += ((AudioFeatures) actual).getLength();
            }
        }
        return fullLength;
    }

    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        for (Feature actual : features) {
            contributors.addAll(actual.getContributors());
        }
        return contributors;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (Feature actual : features) {
            titles.add(actual.getTitle());
        }
        return titles;
    }

    public boolean hasAudioFeature() {
        for (Feature actual : features) {
            if (isAudioFeature(actual)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAudioFeature(Feature actual) {
        return actual.getClass().equals(AudioFeatures.class);
    }

    public boolean hasPrintedFeature() {
        for (Feature actual : features) {
            if (isPrintedFeature(actual)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPrintedFeature(Feature actual) {
        return actual.getClass().equals(PrintedFeatures.class);
    }

    public int numberOfPagesAtOneItem() {
        int numberOfPages = 0;
        for (Feature actual : features) {
            if (isPrintedFeature(actual)) {
                numberOfPages += ((PrintedFeatures) actual).getNumberOfPages();
            }
        }
        return numberOfPages;
    }

    public List<Feature> getFeatures() {
        return List.copyOf(features);
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
