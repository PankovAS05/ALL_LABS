import geometry.Point;
import geometry.PolyLine;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                    scanner.next();
                }
            }
        }

        PolyLine polyLine1 = new PolyLine(points1);
        System.out.println("Первая ломаная линия: " + polyLine1);
        System.out.println("Длина первой ломаной линии: " + polyLine1.getLength());

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

        PolyLine polyLine2 = new PolyLine(points2);
        System.out.println("Вторая ломаная линия: " + polyLine2);
        System.out.println("Длина второй ломаной линии: " + polyLine2.getLength());

        System.out.println("Сравнение первой и второй ломаной линии: " + polyLine1.equals(polyLine2));
    }
}