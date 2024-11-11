import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Point {
    private int x; // Координата X
    private int y; // Координата Y


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }


    public void shift(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }


    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
    }
}


class PolyLine {
    private List<Point> points; // Список точек


    public PolyLine() {
        this.points = new ArrayList<>();
    }


    public PolyLine(List<Point> points) {
        this.points = points;
    }


    public void addPoint(Point point) {
        points.add(point);
    }


    public void addPoints(List<Point> newPoints) {
        points.addAll(newPoints); // Добавляем новые точки к существующим
    }


    public double getLength() {
        double totalLength = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            totalLength += points.get(i).distanceTo(points.get(i + 1)); // Суммируем длины между точками
        }
        return totalLength;
    }


    @Override
    public String toString() {
        return "Линия " + points.toString();
    }
}

public class Main {

    public static Point inputPoint(Scanner scanner) {
        while (true) {
            System.out.print("Введите координаты точки (x y): ");
            String input = scanner.nextLine().trim();
            String[] coords = input.split(" ");
            if (coords.length != 2) {
                System.out.println("Ошибка: введите две координаты, разделенные пробелом.");
                continue;
            }
            try {
                int x = Integer.parseInt(coords[0]);
                int y = Integer.parseInt(coords[1]);
                return new Point(x, y);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: координаты должны быть целыми числами. Попробуйте снова.");
            }
        }
    }


    public static int inputInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value <= 0) {
                    System.out.println("Ошибка: значение должно быть положительным числом. Попробуйте снова.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: значение должно быть целым числом. Попробуйте снова.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создаем первую ломаную
        PolyLine polyLine1 = new PolyLine(); // Создаем пустую ломаную
        System.out.println("Введите количество точек для первой ломаной:");
        int numPoints1 = inputInteger(scanner, "Количество точек: ");
        for (int i = 0; i < numPoints1; i++) {
            polyLine1.addPoint(inputPoint(scanner)); // Добавляем точки
        }


        System.out.println("Первая ломаная: " + polyLine1);


        System.out.println("Длина первой ломаной: " + polyLine1.getLength());


        System.out.println("Сколько новых точек вы хотите добавить?");
        int numNewPoints = inputInteger(scanner, "Количество новых точек: ");
        List<Point> newPoints = new ArrayList<>();
        for (int i = 0; i < numNewPoints; i++) {
            newPoints.add(inputPoint(scanner)); // Ввод новых точек
        }
        polyLine1.addPoints(newPoints); // Добавляем новые точки в первую ломаную


        System.out.println("Первая ломаная после добавления точек: " + polyLine1);


        System.out.println("Обновленная длина первой ломаной: " + polyLine1.getLength());

        scanner.close();
    }
}
