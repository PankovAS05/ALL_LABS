package Geometry;

public class Line implements Lengthable {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public double getLength() {
        return start.distanceTo(end);
    }
}