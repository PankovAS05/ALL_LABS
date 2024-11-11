package ru.pankov.geometry.shapes;

import ru.pankov.geometry.Point;
import ru.pankov.geometry.lines.ClosedPolyLine;

public class Square {
    private Point topLeft;
    private double sideLength;

    public Square(Point topLeft, double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны должна быть положительной.");
        }
        this.topLeft = topLeft;
        this.sideLength = sideLength;
    }

    public ClosedPolyLine getPolygonalChain() {
        ClosedPolyLine polyLine = new ClosedPolyLine();
        polyLine.addPoint(topLeft);
        polyLine.addPoint(new Point(topLeft.getX() + sideLength, topLeft.getY()));
        polyLine.addPoint(new Point(topLeft.getX() + sideLength, topLeft.getY() - sideLength));
        polyLine.addPoint(new Point(topLeft.getX(), topLeft.getY() - sideLength));
        polyLine.addPoint(topLeft); // замыкаем линию
        return polyLine;
    }

    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + sideLength;
    }
}
