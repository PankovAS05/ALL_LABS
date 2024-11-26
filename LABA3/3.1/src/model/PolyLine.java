package model;

import java.util.ArrayList;
import java.util.List;

public class PolyLine {
    protected List<Point> points;

    public PolyLine() {
        this.points = new ArrayList<>();
    }

    public PolyLine(List<Point> points) {
        this.points = points;
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public double length() {
        double totalLength = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            totalLength += points.get(i).distanceTo(points.get(i + 1));
        }
        return totalLength;
    }

    // Метод для получения текстового представления ломаной
    @Override
    public String toString() {
        return "Линия " + points.toString();
    }
}