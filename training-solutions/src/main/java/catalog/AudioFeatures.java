package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {

    private List<String> composer;
    private final int length;
    private final List<String> performers;
    private final String title;

    public AudioFeatures(String title, int length, List<String> performers) {
        validateParameters(title, length, performers);
        this.length = length;
        this.performers = performers;
        this.title = title;
    }

    public AudioFeatures(String title, int length, List<String> composer, List<String> performers) {
        this(title, length, performers);
        validateComposer(composer);
        this.composer = composer;
    }

    private void validateParameters(String title, int length, List<String> performers) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (length < 1) {
            throw new IllegalArgumentException("No pages");
        }
        if (Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("No performers");
        }
    }

    private void validateComposer(List<String> composer) {
        if (Validators.isEmpty(composer)) {
            throw new IllegalArgumentException("No composer");
        }
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>(performers);
        if (!Validators.isEmpty(composer)) {
            contributors.addAll(composer);
        }
        return contributors;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
}
