package Geometry;

import java.util.List;

public class PolyLine implements Lengthable {
    private List<Point> points;

    public PolyLine(List<Point> points) {
        this.points = points;
    }

    @Override
    public double getLength() {
        double length = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            length += points.get(i).distanceTo(points.get(i + 1));
        }
        return length;
    }
}