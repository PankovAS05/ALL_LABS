import geometry.*;
import util.GeometryUtil;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<PolygonalChain> shapes = new ArrayList<>();

        // Ввод нескольких фигур
        while (true) {
            System.out.println("Введите тип фигуры (1 - Квадрат, 2 - Треугольник, 3 - Линия, 0 - Завершить ввод): ");
            int shapeType = scanner.nextInt();

            if (shapeType == 0) {
                break; // Завершаем ввод
            }

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
                    System.out.println("Неверный тип фигуры. Попробуйте снова.");
                    continue; // Пропускаем добавление фигуры при неверном вводе
            }

            // Добавляем фигуру в список
            shapes.add(shape);
        }

        // Проверка, есть ли хотя бы одна фигура для объединения
        if (shapes.isEmpty()) {
            System.out.println("Нет фигур для объединения.");
        } else {
            // Объединяем ломаные линии в одну
            PolyLine combinedPolyLine = GeometryUtil.combinePolygonalChains(shapes);

            // Выводим результат
            System.out.println("Объединенная ломаная линия: " + combinedPolyLine);
            System.out.println("Длина объединенной ломаной линии: " + combinedPolyLine.getLength());
        }

        scanner.close();
    }
}