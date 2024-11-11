import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Класс Point для представления точки на плоскости
class Point {
    private int x;
    private int y;

    // Конструктор
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Геттеры
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Приведение к строковому виду
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    // Метод для сдвига точки
    public void shift(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    // Метод для вычисления расстояния между двумя точками
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
    }
}

// Класс PolyLine для представления ломаной линии
class PolyLine {
    private List<Point> points;

    // Конструктор
    public PolyLine() {
        this.points = new ArrayList<>();
    }

    // Конструктор с параметрами
    public PolyLine(List<Point> points) {
        this.points = points;
    }

    // Метод для добавления точки
    public void addPoint(Point point) {
        points.add(point);
    }

    // Метод для получения всех точек
    public List<Point> getPoints() {
        return points;
    }

    // Метод для вычисления длины ломаной
    public double getLength() {
        double length = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            length += points.get(i).distanceTo(points.get(i + 1));
        }
        return length;
    }

    // Приведение к строковому виду
    @Override
    public String toString() {
        return "Линия " + points.toString();
    }
}

// Класс Square для представления квадрата
class Square {
    private Point topLeft; // Верхний левый угол квадрата
    private int sideLength; // Длина стороны квадрата

    // Конструктор с проверкой длины стороны
    public Square(Point topLeft, int sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны квадрата должна быть положительным числом.");
        }
        this.topLeft = topLeft;
        this.sideLength = sideLength;
    }

    // Конструктор с координатами
    public Square(int x, int y, int sideLength) {
        this(new Point(x, y), sideLength);
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
        List<Point> points = new ArrayList<>();
        points.add(topLeft); // Верхний левый угол
        points.add(new Point(topLeft.getX() + sideLength, topLeft.getY())); // Верхний правый угол
        points.add(new Point(topLeft.getX() + sideLength, topLeft.getY() - sideLength)); // Нижний правый угол
        points.add(new Point(topLeft.getX(), topLeft.getY() - sideLength)); // Нижний левый угол
        points.add(topLeft); // Замыкаем на верхний левый угол

        return new PolyLine(points);
    }

    // Приведение квадрата к строковому виду
    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + sideLength;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Ввод координат и стороны квадрата
            System.out.println("Введите координаты верхнего левого угла квадрата (x и y):");
            System.out.print("x: ");
            int x = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("y: ");
            int y = Integer.parseInt(scanner.nextLine().trim());

            System.out.println("Введите длину стороны квадрата:");
            System.out.print("Сторона: ");
            int sideLength = Integer.parseInt(scanner.nextLine().trim());

            // Создаем квадрат
            Square square = new Square(x, y, sideLength);
            System.out.println("Создан квадрат: " + square);

            // Получаем ломаную из квадратных точек
            PolyLine polyLine = square.toPolyLine();
            System.out.println("Ломаная, соответствующая квадрату: " + polyLine);

            // Выводим длину ломаной
            System.out.println("Длина ломаной: " + polyLine.getLength());

            // Сдвигаем последнюю точку ломаной
            System.out.println("Введите новые координаты для сдвига последней точки ломаной (x и y):");
            System.out.print("Новое значение x: ");
            int newX = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Новое значение y: ");
            int newY = Integer.parseInt(scanner.nextLine().trim());

            // Сдвигаем последнюю точку (последняя точка перед замыканием на первую)
            List<Point> points = polyLine.getPoints();
            Point lastPoint = points.get(points.size() - 2); // Последняя точка перед замыканием
            lastPoint.shift(newX - lastPoint.getX(), newY - lastPoint.getY());

            // Выводим обновленную ломаную и её длину
            System.out.println("Ломаная после сдвига последней точки: " + polyLine);
            System.out.println("Обновленная длина ломаной: " + polyLine.getLength());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода: введите корректные числовые значения.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
