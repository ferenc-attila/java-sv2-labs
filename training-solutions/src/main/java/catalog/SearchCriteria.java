package catalog;

public class SearchCriteria {

    private final String contributor;
    private final String title;

    public static SearchCriteria createByBoth(String title, String contributor) {
        validateContributor(contributor);
        validateTitle(title);
        return new SearchCriteria(contributor, title);
    }

    public static SearchCriteria createByContributor(String contributor) {
        validateContributor(contributor);
        return new SearchCriteria(contributor, "");
    }

    public static SearchCriteria createByTitle(String title) {
        validateTitle(title);
        return new SearchCriteria("", title);
    }

    public boolean hasContributor() {
        return (!contributor.equals(""));
    }

    public boolean hasTitle() {
        return (!title.equals(""));
    }

    private SearchCriteria(String contributor, String title) {
        this.contributor = contributor;
        this.title = title;
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }

    private static void validateContributor(String contributor) {
        if (Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("Empty contributor!");
        }
    }

    private static void validateTitle(String title) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title!");
        }
    }
}
