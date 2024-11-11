import java.util.Scanner;

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}

interface Shape {
    double calculateArea();
}

abstract class AbstractShape implements Shape {
    @Override
    public abstract String toString();
}

class Circle extends AbstractShape {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Круг в точке " + center.toString() + " с радиусом " + radius;
    }
}

class Square extends AbstractShape {
    private Point topLeft;
    private double side;

    public Square(Point topLeft, double side) {
        this.topLeft = topLeft;
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft.toString() + " со стороной " + side;
    }
}

class Rectangle extends AbstractShape {
    private Point topLeft;
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Прямоугольник в точке " + topLeft.toString() + " с шириной " + width + " и высотой " + height;
    }
}

class Triangle extends AbstractShape {
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    @Override
    public double calculateArea() {
        return Math.abs((point1.getX() * (point2.getY() - point3.getY()) +
                point2.getX() * (point3.getY() - point1.getY()) +
                point3.getX() * (point1.getY() - point2.getY())) / 2.0);
    }

    @Override
    public String toString() {
        return "Треугольник с вершинами " + point1.toString() + ", " + point2.toString() + ", " + point3.toString();
    }
}

public class Main {

    private static double getPositiveDoubleInput(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value > 0) {
                    break;
                } else {
                    System.out.println("Ошибка: значение должно быть положительным.");
                }
            } else {
                System.out.println("Ошибка: введено не число.");
                scanner.next(); // Очищаем буфер
            }
        }
        return value;
    }

    private static Point getPointInput(Scanner scanner, String prompt) {
        double x = getPositiveDoubleInput(scanner, prompt + " (x): ");
        double y = getPositiveDoubleInput(scanner, prompt + " (y): ");
        return new Point(x, y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных для круга
        System.out.println("Ввод данных для круга:");
        Point center = getPointInput(scanner, "Введите координаты центра круга");
        double radius = getPositiveDoubleInput(scanner, "Введите радиус круга");
        Circle circle = new Circle(center, radius);
        System.out.println(circle);
        System.out.println("Площадь круга: " + circle.calculateArea());

        // Ввод данных для квадрата
        System.out.println("Ввод данных для квадрата:");
        Point topLeftSquare = getPointInput(scanner, "Введите координаты левого верхнего угла квадрата");
        double side = getPositiveDoubleInput(scanner, "Введите сторону квадрата");
        Square square = new Square(topLeftSquare, side);
        System.out.println(square);
        System.out.println("Площадь квадрата: " + square.calculateArea());

        // Ввод данных для прямоугольника
        System.out.println("Ввод данных для прямоугольника:");
        Point topLeftRect = getPointInput(scanner, "Введите координаты левого верхнего угла прямоугольника");
        double width = getPositiveDoubleInput(scanner, "Введите ширину прямоугольника");
        double height = getPositiveDoubleInput(scanner, "Введите высоту прямоугольника");
        Rectangle rectangle = new Rectangle(topLeftRect, width, height);
        System.out.println(rectangle);
        System.out.println("Площадь прямоугольника: " + rectangle.calculateArea());

        // Ввод данных для треугольника
        System.out.println("Ввод данных для треугольника:");
        System.out.println("Введите координаты трех вершин треугольника:");
        Point point1 = getPointInput(scanner, "Введите координаты первой вершины треугольника");
        Point point2 = getPointInput(scanner, "Введите координаты второй вершины треугольника");
        Point point3 = getPointInput(scanner, "Введите координаты третьей вершины треугольника");
        Triangle triangle = new Triangle(point1, point2, point3);
        System.out.println(triangle);
        System.out.println("Площадь треугольника: " + triangle.calculateArea());
    }
}
