package stringconcat.nameconcat;

public enum Title {

    MR("Mr."), MRS("Mrs."), MS("Ms."), DR("Dr.");

    private final String title;

    Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
