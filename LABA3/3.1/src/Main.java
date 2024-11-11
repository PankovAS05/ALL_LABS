import java.util.ArrayList;
import java.util.List;

// Класс Точка, используемый для представления координат (из предыдущей задачи)
class Point {
    private double x;
    private double y;

    // Конструктор для инициализации точки
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Метод для получения расстояния между двумя точками
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    // Переопределение метода toString для красивого вывода точки
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}

// Класс Ломаная (PolyLine)
class PolyLine {
    protected List<Point> points;

    // Конструктор без аргументов
    public PolyLine() {
        this.points = new ArrayList<>();
    }

    // Конструктор, принимающий список точек
    public PolyLine(List<Point> points) {
        this.points = points;
    }

    // Добавление точки в ломаную линию
    public void addPoint(Point point) {
        points.add(point);
    }

    // Метод для вычисления длины ломаной
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

// Класс Замкнутая Ломаная (ClosedPolyLine), наследующий от PolyLine
class ClosedPolyLine extends PolyLine {

    // Конструктор для создания замкнутой ломаной линии
    public ClosedPolyLine() {
        super();
    }

    // Конструктор для создания замкнутой ломаной линии с передачей точек
    public ClosedPolyLine(List<Point> points) {
        super(points);
    }

    // Метод для вычисления длины замкнутой ломаной
    @Override
    public double length() {
        double totalLength = super.length();
        if (points.size() > 1) {
            // Добавляем расстояние от последней точки к первой
            totalLength += points.get(points.size() - 1).distanceTo(points.get(0));
        }
        return totalLength;
    }

    // Переопределение метода toString для вывода замкнутой ломаной
    @Override
    public String toString() {
        return "Замкнутая " + super.toString();
    }
}

// Основной класс для демонстрации
public class Main {
    public static void main(String[] args) {
        // Создание обычной ломаной
        PolyLine polyLine = new PolyLine();
        polyLine.addPoint(new Point(1, 5));
        polyLine.addPoint(new Point(2, 8));
        polyLine.addPoint(new Point(5, 3));

        System.out.println(polyLine);
        System.out.println("Длина ломаной: " + polyLine.length());

        // Создание замкнутой ломаной
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 5));
        points.add(new Point(2, 8));
        points.add(new Point(5, 3));
        points.add(new Point(1, 5)); // Точка замыкания

        ClosedPolyLine closedPolyLine = new ClosedPolyLine(points);

        System.out.println(closedPolyLine);
        System.out.println("Длина замкнутой ломаной: " + closedPolyLine.length());
    }
}
