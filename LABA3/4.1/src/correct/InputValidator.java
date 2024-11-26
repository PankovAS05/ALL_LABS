package correct;

import java.util.Scanner;
import geometry.Point;

public class InputValidator {

    private static final Scanner scanner = new Scanner(System.in);

    public static double getPositiveDoubleInput(String prompt) {
        double value = -1;
        while (value <= 0) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value <= 0) {
                    System.out.println("Число должно быть положительным!");
                }
            } else {
                System.out.println("Пожалуйста, введите положительное число.");
                scanner.next(); // discard invalid input
            }
        }
        return value;
    }

    public static Point getPointInput(String prompt) {
        System.out.print(prompt);
        double x = getPositiveDoubleInput("Введите координату X: ");
        double y = getPositiveDoubleInput("Введите координату Y: ");
        return new Point(x, y);
    }
}