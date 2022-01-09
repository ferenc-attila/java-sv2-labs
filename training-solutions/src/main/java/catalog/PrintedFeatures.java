package catalog;

import java.util.List;

public class PrintedFeatures implements Feature {

    private final List<String> authors;
    private final int numberOfPages;
    private final String title;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        validateParameters(title, numberOfPages, authors);
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.title = title;
    }

    @Override
    public List<String> getContributors() {
        return List.copyOf(authors);
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    private void validateParameters(String title, int length, List<String> authors) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (length < 1) {
            throw new IllegalArgumentException("No pages");
        }
        if (Validators.isEmpty(authors)) {
            throw new IllegalArgumentException("No authors");
        }
    }
}
