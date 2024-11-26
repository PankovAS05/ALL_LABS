package shapes;

import geometry.Point;

public class Rectangle {
    private Point topLeft;
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        this.topLeft = topLeft;
        setDimensions(width, height);
    }

    public void setDimensions(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Ширина и высота должны быть положительными числами.");
        }
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Прямоугольник в точке " + topLeft + " с размерами " + width + " x " + height;
    }
}
