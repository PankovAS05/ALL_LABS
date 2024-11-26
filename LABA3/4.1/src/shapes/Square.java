package shapes;

import geometry.Point;

public class Square {
    private Point topLeft;
    private double side;

    public Square(Point topLeft, double side) {
        this.topLeft = topLeft;
        setSide(side);
    }

    public void setSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона квадрата должна быть положительным числом.");
        }
        this.side = side;
    }

    public double calculateArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + side;
    }
}