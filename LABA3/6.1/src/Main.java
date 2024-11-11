import java.util.*;
import java.util.InputMismatchException;

// Точка с координатами x и y
class Point {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public String toString() {
        return String.format("{%.2f; %.2f}", x, y);
    }
}

// Ломаная линия, состоящая из списка точек
class PolyLine {
    List<Point> points;

    public PolyLine(List<Point> points) {
        this.points = points;
    }

    public double getLength() {
        double length = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            length += points.get(i).distanceTo(points.get(i + 1));
        }
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PolyLine polyLine = (PolyLine) obj;
        return points.equals(polyLine.points);  // Сравниваем списки точек
    }

    @Override
    public String toString() {
        return "Линия " + points;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод количества точек для первой ломаной линии
        int n = 0;
        while (n <= 0) {
            try {
                System.out.print("Введите количество точек для первой ломаной линии: ");
                n = scanner.nextInt();
                if (n <= 0) {
                    System.out.println("Количество точек должно быть больше 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Введите целое число.");
                scanner.next(); // Очистка ввода
            }
        }

        // Ввод точек для первой ломаной линии
        List<Point> points1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double x = 0, y = 0;
            while (x == 0 || y == 0) {
                try {
                    System.out.print("Введите координаты точки " + (i + 1) + " (x y): ");
                    x = scanner.nextDouble();
                    y = scanner.nextDouble();
                    points1.add(new Point(x, y));
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка ввода. Введите два числа для координат.");
                    scanner.next(); // Очистка ввода
                }
            }
        }

        // Создание первой ломаной линии
        PolyLine polyLine1 = new PolyLine(points1);
        System.out.println("Первая ломаная линия: " + polyLine1);
        System.out.println("Длина первой ломаной линии: " + polyLine1.getLength());

        // Ввод количества точек для второй ломаной линии
        int m = 0;
        while (m <= 0) {
            try {
                System.out.print("Введите количество точек для второй ломаной линии: ");
                m = scanner.nextInt();
                if (m <= 0) {
                    System.out.println("Количество точек должно быть больше 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Введите целое число.");
                scanner.next(); // Очистка ввода
            }
        }

        // Ввод точек для второй ломаной линии
        List<Point> points2 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            double x = 0, y = 0;
            while (x == 0 || y == 0) {
                try {
                    System.out.print("Введите координаты точки " + (i + 1) + " (x y): ");
                    x = scanner.nextDouble();
                    y = scanner.nextDouble();
                    points2.add(new Point(x, y));
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка ввода. Введите два числа для координат.");
                    scanner.next(); // Очистка ввода
                }
            }
        }

        // Создание второй ломаной линии
        PolyLine polyLine2 = new PolyLine(points2);
        System.out.println("Вторая ломаная линия: " + polyLine2);
        System.out.println("Длина второй ломаной линии: " + polyLine2.getLength());

        // Сравнение ломаных линий
        System.out.println("Сравнение первой и второй ломаной линии: " + polyLine1.equals(polyLine2));
    }
}
