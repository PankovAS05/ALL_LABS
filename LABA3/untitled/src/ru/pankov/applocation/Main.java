package ru.pankov.applocation;

import ru.pankov.geometry.shapes.Rectangle;
import ru.pankov.geometry.shapes.Square;
import ru.pankov.geometry.shapes.Triangle;
import ru.pankov.geometry.Point;
import ru.pankov.math.Pow;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Показать главное меню
            System.out.println("Выберите действие:");
            System.out.println("1. Работа с квадратом");
            System.out.println("2. Работа с прямоугольником");
            System.out.println("3. Работа с треугольником");
            System.out.println("4. Возведение числа в степень");
            System.out.println("5. Выйти");

            // Получить выбор пользователя
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // Работа с квадратом
                    handleSquare(scanner);
                    break;
                case "2":
                    // Работа с прямоугольником
                    handleRectangle(scanner);
                    break;
                case "3":
                    // Работа с треугольником
                    handleTriangle(scanner);
                    break;
                case "4":
                    // Новый пункт - возведение числа в степень
                    handlePower(scanner);
                    break;
                case "5":
                    // Выход из программы
                    System.out.println("Программа завершена.");
                    return;
                default:
                    // Неверный ввод
                    System.out.println("Неверный выбор. Попробуйте снова.");
                    break;
            }
        }
    }

    // Обработчик для работы с квадратом
    private static void handleSquare(Scanner scanner) {
        // Пример обработки квадрата
        System.out.println("Введите координаты левого верхнего угла квадрата (x, y) и размер стороны:");
        try {
            int x = Integer.parseInt(scanner.nextLine());
            int y = Integer.parseInt(scanner.nextLine());
            int side = Integer.parseInt(scanner.nextLine());

            Square square = new Square(new Point(x, y), side);
            System.out.println("Создан " + square);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода. Введите корректные числа.");
        }
    }

    // Обработчик для работы с прямоугольником
    private static void handleRectangle(Scanner scanner) {
        System.out.println("Введите координаты левого верхнего угла прямоугольника (x, y) и размеры сторон:");
        try {
            int x = Integer.parseInt(scanner.nextLine());
            int y = Integer.parseInt(scanner.nextLine());
            int width = Integer.parseInt(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            Rectangle rectangle = new Rectangle(new Point(x, y), width, height);
            System.out.println("Создан " + rectangle);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода. Введите корректные числа.");
        }
    }

    // Обработчик для работы с треугольником
    private static void handleTriangle(Scanner scanner) {
        System.out.println("Введите координаты трех точек треугольника (x1, y1, x2, y2, x3, y3):");
        try {
            int x1 = Integer.parseInt(scanner.nextLine());
            int y1 = Integer.parseInt(scanner.nextLine());
            int x2 = Integer.parseInt(scanner.nextLine());
            int y2 = Integer.parseInt(scanner.nextLine());
            int x3 = Integer.parseInt(scanner.nextLine());
            int y3 = Integer.parseInt(scanner.nextLine());

            Triangle triangle = new Triangle(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
            System.out.println("Создан " + triangle);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода. Введите корректные числа.");
        }
    }

    // Обработчик для возведения числа в степень
    private static void handlePower(Scanner scanner) {
        System.out.println("Введите два числа (X и Y):");

        // Проверка ввода чисел
        try {
            String xStr = scanner.nextLine();
            String yStr = scanner.nextLine();
            double result = Pow.power(xStr, yStr);

            // Вывод результата
            System.out.println("Результат возведения в степень: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: оба аргумента должны быть целыми числами.");
        }
    }
}