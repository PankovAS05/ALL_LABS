import java.util.*;

// Интерфейс, который должен реализовывать любой объект, у которого есть длина
interface Lengthable {
    double getLength();
}

// Класс Точка, который хранит координаты x и y и позволяет вычислять расстояние до другой точки
class Point {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Метод для вычисления расстояния между двумя точками
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    @Override
    public String toString() {
        return String.format("{%.2f; %.2f}", x, y);
    }
}

// Класс Линия, который представляет собой отрезок между двумя точками
class Line implements Lengthable {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Метод для получения длины отрезка
    @Override
    public double getLength() {
        return start.distanceTo(end);
    }
}

// Класс Ломаная линия, которая состоит из нескольких точек
class PolyLine implements Lengthable {
    private List<Point> points;

    public PolyLine(List<Point> points) {
        this.points = points;
    }

    // Метод для получения длины ломаной линии
    @Override
    public double getLength() {
        double length = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            length += points.get(i).distanceTo(points.get(i + 1));
        }
        return length;
    }
}

// Класс для вычисления общей длины всех объектов, которые реализуют интерфейс Lengthable
class LengthCalculator {
    public static double calculateTotalLength(List<Lengthable> objects) {
        double totalLength = 0;
        for (Lengthable object : objects) {
            totalLength += object.getLength();
        }
        return totalLength;
    }
}

// Основной класс с примером использования
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    // Метод для безопасного ввода целого числа
    public static int safeNextInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
            scanner.next(); // Читаем некорректный ввод
        }
        return scanner.nextInt();
    }

    // Метод для безопасного ввода числа с плавающей точкой
    public static double safeNextDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Некорректный ввод. Пожалуйста, введите число.");
            scanner.next(); // Читаем некорректный ввод
        }
        return scanner.nextDouble();
    }

    public static void main(String[] args) {
        // Ввод точек для Ломаной линии
        System.out.println("Введите количество точек для ломаной линии:");
        int n = safeNextInt();

        List<Point> polyLinePoints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Введите координаты точки " + (i + 1) + ":");
            System.out.print("x: ");
            double x = safeNextDouble();
            System.out.print("y: ");
            double y = safeNextDouble();
            polyLinePoints.add(new Point(x, y));
        }

        // Создание ломаной линии
        PolyLine polyLine = new PolyLine(polyLinePoints);

        // Ввод точек для Линии
        System.out.println("Введите координаты начала и конца линии:");
        System.out.print("x1: ");
        double x1 = safeNextDouble();
        System.out.print("y1: ");
        double y1 = safeNextDouble();
        System.out.print("x2: ");
        double x2 = safeNextDouble();
        System.out.print("y2: ");
        double y2 = safeNextDouble();

        Line line = new Line(new Point(x1, y1), new Point(x2, y2));

        // Добавляем объекты в список
        List<Lengthable> objects = Arrays.asList(polyLine, line);

        // Расчитываем и выводим сумму длин всех объектов
        double totalLength = LengthCalculator.calculateTotalLength(objects);
        System.out.println("Сумма длин всех объектов: " + totalLength);
    }
}
