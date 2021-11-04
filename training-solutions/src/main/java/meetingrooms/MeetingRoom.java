package meetingrooms;

public class MeetingRoom {

    private String name;
    private final int length;
    private final int width;

    public MeetingRoom(String name, int length, int width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    public int getArea() {
        return length * width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
