package geometry;

import line.PolyLine;
import java.util.ArrayList;
import java.util.List;

// Класс Square для представления квадрата
public class Square {
    private point topLeft; // Верхний левый угол квадрата
    private int sideLength; // Длина стороны квадрата

    // Конструктор с проверкой длины стороны
    public Square(point topLeft, int sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны квадрата должна быть положительным числом.");
        }
        this.topLeft = topLeft;
        this.sideLength = sideLength;
    }

    // Конструктор с координатами
    public Square(int x, int y, int sideLength) {
        this(new point(x, y), sideLength);
    }

    // Метод для изменения длины стороны
    public void setSideLength(int sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны квадрата должна быть положительным числом.");
        }
        this.sideLength = sideLength;
    }

    // Метод для получения длины стороны
    public int getSideLength() {
        return this.sideLength;
    }

    // Метод для получения ломаной, соответствующей углам квадрата
    public PolyLine toPolyLine() {
        List<point> points = new ArrayList<>();
        points.add(topLeft); // Верхний левый угол
        points.add(new point(topLeft.getX() + sideLength, topLeft.getY())); // Верхний правый угол
        points.add(new point(topLeft.getX() + sideLength, topLeft.getY() - sideLength)); // Нижний правый угол
        points.add(new point(topLeft.getX(), topLeft.getY() - sideLength)); // Нижний левый угол
        points.add(topLeft);

        return new PolyLine(points);
    }

    // Приведение квадрата к строковому виду
    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + sideLength;
    }
}
