import Calculator.LengthCalculator;
import Geometry.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static int safeNextInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
            scanner.next(); // Читаем некорректный ввод
        }
        return scanner.nextInt();
    }

    public static double safeNextDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Некорректный ввод. Пожалуйста, введите число.");
            scanner.next(); // Читаем некорректный ввод
        }
        return scanner.nextDouble();
    }

    public static void main(String[] args) {
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

        PolyLine polyLine = new PolyLine(polyLinePoints);

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

        List<Lengthable> objects = Arrays.asList(polyLine, line);

        double totalLength = LengthCalculator.calculateTotalLength(objects);
        System.out.println("Сумма длин всех объектов: " + totalLength);
    }
}