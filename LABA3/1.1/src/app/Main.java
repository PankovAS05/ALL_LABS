package app;

import geometry.point;
import geometry.Square;
import line.PolyLine;
import java.util.List;
import java.util.Scanner;

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
            List<point> points = polyLine.getPoints();
            point lastPoint = points.get(points.size() - 2);
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
