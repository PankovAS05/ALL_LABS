package geometry;

import java.util.*;


public class PolyLine {
    private List<Point> points;

    public PolyLine(List<Point> points) {
        this.points = points;
    }

    public double getLength() {
        double length = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            length += points.get(i).distanceTo(points.get(i + 1));
        }
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PolyLine polyLine = (PolyLine) obj;
        return points.equals(polyLine.points);
    }

    @Override
    public String toString() {
        return "Линия " + points;
    }
}