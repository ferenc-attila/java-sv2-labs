package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem item) {
        catalogItems.add(item);
    }

    public double averagePageNumberOver(int value) {
        validatePageValue(value);
        double sumOfPages = 0;
        int count = 0;
        for (CatalogItem actual : catalogItems) {
            if (actual.numberOfPagesAtOneItem() >= value) {
                sumOfPages += actual.numberOfPagesAtOneItem();
                count++;
            }
        }
        return getAverage(sumOfPages, count);
    }

    private void validatePageValue(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("Page number must be positive");
        }
    }

    private double getAverage(double sumOfPages, int count) {
        if (count == 0) {
            throw new IllegalArgumentException("No page");
        }
        return sumOfPages / count;
    }

    public void deleteItemByRegistrationNumber(String registrationNUmber) {
        for (int i = 0; i < catalogItems.size(); i++) {
            if (registrationNUmber.equals(catalogItems.get(i).getRegistrationNumber())) {
                catalogItems.remove(catalogItems.get(i));
            }
        }
    }

    public List<CatalogItem> findByCriteria(SearchCriteria criteria) {
        List<CatalogItem> found = new ArrayList<>();
        if (criteria.hasContributor()) {
            addCatalogItemByContributor(criteria, found);
        }
        if (criteria.hasTitle()) {
            addCatalogItemByTitle(criteria, found);
        }
        return found;
    }

    private void addCatalogItemByTitle(SearchCriteria criteria, List<CatalogItem> found) {
        for (CatalogItem actual : catalogItems) {
            if (actual.getTitles().contains(criteria.getTitle()) && !(found.contains(actual))) {
                found.add(actual);
            }
        }
    }

    private void addCatalogItemByContributor(SearchCriteria criteria, List<CatalogItem> found) {
        for (CatalogItem actual : catalogItems) {
            if (actual.getContributors().contains(criteria.getContributor()) && !(found.contains(actual))) {
                found.add(actual);
            }
        }
    }

    public int getAllPageNumber() {
        int pages = 0;
        for (CatalogItem actual : catalogItems) {
            pages += actual.numberOfPagesAtOneItem();
        }
        return pages;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audioLibraryItems = new ArrayList<>();
        for (CatalogItem actual : catalogItems) {
            if (actual.hasAudioFeature()) {
                audioLibraryItems.add(actual);
            }
        }
        return audioLibraryItems;
    }

    public int getFullLength() {
        int length = 0;
        for (CatalogItem actual : catalogItems) {
            length += actual.fullLengthAtOneItem();
        }
        return length;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> printedLibraryItems = new ArrayList<>();
        for (CatalogItem actual : catalogItems) {
            if (actual.hasPrintedFeature()) {
                printedLibraryItems.add(actual);
            }
        }
        return printedLibraryItems;
    }
}
