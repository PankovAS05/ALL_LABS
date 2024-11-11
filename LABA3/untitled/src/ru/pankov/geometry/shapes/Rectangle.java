package ru.pankov.geometry.shapes;

import ru.pankov.geometry.Point;
import ru.pankov.geometry.lines.ClosedPolyLine;

public class Rectangle {
    private Point topLeft;
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Ширина и высота должны быть положительными.");
        }
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    public ClosedPolyLine getPolygonalChain() {
        ClosedPolyLine polyLine = new ClosedPolyLine();
        polyLine.addPoint(topLeft);
        polyLine.addPoint(new Point(topLeft.getX() + width, topLeft.getY()));
        polyLine.addPoint(new Point(topLeft.getX() + width, topLeft.getY() - height));
        polyLine.addPoint(new Point(topLeft.getX(), topLeft.getY() - height));
        polyLine.addPoint(topLeft); // замыкаем линию
        return polyLine;
    }

    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Прямоугольник в точке " + topLeft + " с шириной " + width + " и высотой " + height;
    }
}
