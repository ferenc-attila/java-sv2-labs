package methodchain;

public class Grasshopper {

    private int position;

    public Grasshopper() {
        this.position = 0;
    }

    public Grasshopper hopOnce(Direction direction) {
        if (direction == Direction.POSITIVE) {
            this.position++;
        } else {
            this.position--;
        }
        return this;
    }

    void moveFromZeroToThreeWithFiveHops() {
        this.hopOnce(Direction.POSITIVE).hopOnce(Direction.POSITIVE).hopOnce(Direction.NEGATIVE).hopOnce(Direction.POSITIVE).hopOnce(Direction.POSITIVE);
    }

    public int getPosition() {
        return position;
    }
}
