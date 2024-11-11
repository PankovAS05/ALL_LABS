package ru.pankov.geometry.lines;

import ru.pankov.geometry.Point;
import java.util.ArrayList;
import java.util.List;

public class PolyLine {
    protected List<Point> points = new ArrayList<>();

    public void addPoint(Point point) {
        points.add(point);
    }

    public double getLength() {
        double length = 0.0;
        for (int i = 1; i < points.size(); i++) {
            length += Math.sqrt(Math.pow(points.get(i).getX() - points.get(i - 1).getX(), 2)
                    + Math.pow(points.get(i).getY() - points.get(i - 1).getY(), 2));
        }
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (Point p : points) {
            sb.append(p.toString()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
