package ru.pankov.geometry.shapes;

import ru.pankov.geometry.Point;
import ru.pankov.geometry.lines.ClosedPolyLine;

public class Triangle {
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public ClosedPolyLine getPolygonalChain() {
        ClosedPolyLine polyLine = new ClosedPolyLine();
        polyLine.addPoint(point1);
        polyLine.addPoint(point2);
        polyLine.addPoint(point3);
        polyLine.addPoint(point1); // замыкаем линию
        return polyLine;
    }

    public double getArea() {
        double a = Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) + Math.pow(point2.getY() - point1.getY(), 2));
        double b = Math.sqrt(Math.pow(point3.getX() - point2.getX(), 2) + Math.pow(point3.getY() - point2.getY(), 2));
        double c = Math.sqrt(Math.pow(point3.getX() - point1.getX(), 2) + Math.pow(point3.getY() - point1.getY(), 2));
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String toString() {
        return "Треугольник с вершинами " + point1 + ", " + point2 + " и " + point3;
    }
}
