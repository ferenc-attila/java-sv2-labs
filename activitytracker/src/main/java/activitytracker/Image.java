package activitytracker;

public class Image {

    private Long id;
    private String filename;
    private byte[] content;

    public Image(Long id, String filename, byte[] content) {
        this.id = id;
        this.filename = filename;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public byte[] getContent() {
        return content;
    }
}
