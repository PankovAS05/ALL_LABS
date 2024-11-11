import java.util.*;

// Точка с координатами x и y
class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    @Override
    public String toString() {
        return String.format("{%.2f; %.2f}", x, y);
    }
}

// Интерфейс для объектов, которые могут быть преобразованы в ломаную линию
interface PolygonalChain {
    PolyLine getPolygonalChain();
}

// Ломаная линия, состоящая из списка точек
class PolyLine implements PolygonalChain {
    List<Point> points;

    public PolyLine(List<Point> points) {
        this.points = points;
    }

    @Override
    public PolyLine getPolygonalChain() {
        return this; // Ломаная линия уже есть
    }

    public double getLength() {
        double length = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            length += points.get(i).distanceTo(points.get(i + 1));
        }
        return length;
    }

    @Override
    public String toString() {
        return "Линия " + points;
    }
}

// Класс для линии (прямой)
class Line implements PolygonalChain {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public PolyLine getPolygonalChain() {
        return new PolyLine(Arrays.asList(start, end));
    }

    public double getLength() {
        return start.distanceTo(end);
    }
}

// Квадрат
class Square implements PolygonalChain {
    private Point topLeft;
    private double sideLength;

    public Square(Point topLeft, double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Сторона квадрата должна быть положительной.");
        }
        this.topLeft = topLeft;
        this.sideLength = sideLength;
    }

    @Override
    public PolyLine getPolygonalChain() {
        Point topRight = new Point(topLeft.x + sideLength, topLeft.y);
        Point bottomLeft = new Point(topLeft.x, topLeft.y - sideLength);
        Point bottomRight = new Point(topLeft.x + sideLength, topLeft.y - sideLength);
        return new PolyLine(Arrays.asList(topLeft, topRight, bottomRight, bottomLeft, topLeft)); // Замкнутый контур
    }
}

// Треугольник
class Triangle implements PolygonalChain {
    private Point p1, p2, p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public PolyLine getPolygonalChain() {
        return new PolyLine(Arrays.asList(p1, p2, p3, p1)); // Замкнутый треугольник
    }
}

// Утилитный класс для работы с геометрическими объектами
class GeometryUtil {
    // Метод для объединения ломаных линий
    public static PolyLine combinePolygonalChains(List<PolygonalChain> chains) {
        List<Point> combinedPoints = new ArrayList<>();

        for (PolygonalChain chain : chains) {
            PolyLine polyLine = chain.getPolygonalChain();
            combinedPoints.addAll(polyLine.points);
        }

        return new PolyLine(combinedPoints);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод для создания объектов
        System.out.println("Введите тип фигуры (1 - Квадрат, 2 - Треугольник, 3 - Линия): ");
        int shapeType = scanner.nextInt();

        PolygonalChain shape = null;
        switch (shapeType) {
            case 1: // Квадрат
                System.out.print("Введите координаты левого верхнего угла квадрата (x y): ");
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                Point topLeft = new Point(x, y);
                System.out.print("Введите длину стороны квадрата: ");
                double sideLength = scanner.nextDouble();
                shape = new Square(topLeft, sideLength);
                break;

            case 2: // Треугольник
                System.out.println("Введите координаты трех точек треугольника (x1 y1 x2 y2 x3 y3): ");
                Point p1 = new Point(scanner.nextDouble(), scanner.nextDouble());
                Point p2 = new Point(scanner.nextDouble(), scanner.nextDouble());
                Point p3 = new Point(scanner.nextDouble(), scanner.nextDouble());
                shape = new Triangle(p1, p2, p3);
                break;

            case 3: // Линия
                System.out.println("Введите координаты начала и конца линии (x1 y1 x2 y2): ");
                Point start = new Point(scanner.nextDouble(), scanner.nextDouble());
                Point end = new Point(scanner.nextDouble(), scanner.nextDouble());
                shape = new Line(start, end);
                break;

            default:
                System.out.println("Неверный тип фигуры.");
                return;
        }

        // Создаем список из фигур
        List<PolygonalChain> shapes = new ArrayList<>();
        shapes.add(shape);

        // Объединяем ломаные линии в одну
        PolyLine combinedPolyLine = GeometryUtil.combinePolygonalChains(shapes);

        // Выводим результат
        System.out.println("Объединенная ломаная линия: " + combinedPolyLine);
        System.out.println("Длина объединенной ломаной линии: " + combinedPolyLine.getLength());

        scanner.close();
    }
}
