package geometry;

import java.util.List;

public class PolyLine implements PolygonalChain {
    public List<Point> points;

    public PolyLine(List<Point> points) {
        this.points = points;
    }

    @Override
    public PolyLine getPolygonalChain() {
        return this;
    }

    public double getLength() {
        double length = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            length += points.get(i).distanceTo(points.get(i + 1));
        }
        return length;
    }

    @Override
    public String toString() {
        return "Линия " + points;
    }
}