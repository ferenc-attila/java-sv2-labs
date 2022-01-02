package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot {

    private Point position;
    private int angle;
    private List<Point> path = new ArrayList<>();
    public static final long ALTITUDE = 5;

    public AstroBoy(Point position) {
        this.position = position;
    }

    private void walkTo(Point position) {
        this.position = position;
        path.add(position);
    }

    private void flyTo(Point position) {
        this.position = position;
        path.add(position);
    }

    @Override
    public void liftTo(long altitude) {
        Point raisedPosition = new Point(position.getX(), position.getY(), altitude);
        this.position = raisedPosition;
        path.add(raisedPosition);
    }

    @Override
    public void moveTo(Point position) {
        walkTo(position);
    }

    @Override
    public void fastMoveTo(Point position) {
        liftTo(ALTITUDE);
        Point  targetPosition = new Point(position.getX(), position.getY(), ALTITUDE);
        flyTo(targetPosition);
        liftTo(0);
    }

    @Override
    public void rotate(int angle) {
        this.angle = angle;
    }

    @Override
    public List<Point> getPath() {
        return new ArrayList<>(path);
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    public long getAltitude() {
        return position.getZ();
    }
}
