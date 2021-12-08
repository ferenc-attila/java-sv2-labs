package abstractclass.gamecharacter;

public final class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public long getDistance (Point anotherPoint) {
        return (long)(Math.sqrt(Math.pow((this.x - anotherPoint.getX()),2) + Math.pow((this.y - anotherPoint.getY()), 2)));
    }
}
