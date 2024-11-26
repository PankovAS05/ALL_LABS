package main;

import model.Point;
import model.PolyLine;
import model.ClosedPolyLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание обычной ломаной
        PolyLine polyLine = new PolyLine();
        System.out.println("Введите количество точек для ломаной:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Введите координаты точки " + (i + 1) + ":");
            System.out.print("X: ");
            double x = scanner.nextDouble();
            System.out.print("Y: ");
            double y = scanner.nextDouble();
            polyLine.addPoint(new Point(x, y));
        }

        System.out.println("Обычная ломаная: " + polyLine);
        System.out.println("Длина ломаной: " + polyLine.length());

        // Создание замкнутой ломаной
        List<Point> closedPoints = new ArrayList<>();
        System.out.println("Введите количество точек для замкнутой ломаной:");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Введите координаты точки " + (i + 1) + ":");
            System.out.print("X: ");
            double x = scanner.nextDouble();
            System.out.print("Y: ");
            double y = scanner.nextDouble();
            closedPoints.add(new Point(x, y));
        }
        // Добавление первой точки в конец для замыкания линии
        closedPoints.add(closedPoints.get(0));

        ClosedPolyLine closedPolyLine = new ClosedPolyLine(closedPoints);

        System.out.println("Замкнутая ломаная: " + closedPolyLine);
        System.out.println("Длина замкнутой ломаной: " + closedPolyLine.length());

        // Сдвиг последней точки замкнутой ломаной
        System.out.println("Введите сдвиг для последней точки замкнутой ломаной (X и Y):");
        double shiftX = scanner.nextDouble();
        double shiftY = scanner.nextDouble();

        Point lastPoint = closedPoints.get(closedPoints.size() - 1);
        closedPoints.set(closedPoints.size() - 1, new Point(lastPoint.x + shiftX, lastPoint.y + shiftY));

        System.out.println("После сдвига последней точки замкнутая ломаная: " + closedPolyLine);
        System.out.println("Длина замкнутой ломаной после сдвига: " + closedPolyLine.length());
    }
}