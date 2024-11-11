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
}


class PolyLine {
    private List<Point> points; // Список точек


    public PolyLine(List<Point> points) {
        this.points = points; // Принимаем список точек
    }


    @Override
    public String toString() {
        return "Линия " + points.toString();
    }


    public void shiftStart(int deltaX, int deltaY) {
        if (!points.isEmpty()) {
            points.get(0).shift(deltaX, deltaY); // Сдвигаем только первую точку
        }
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
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: значение должно быть целым числом. Попробуйте снова.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Список для точек
        List<Point> points = new ArrayList<>();

        // Ввод точек
        System.out.println("Введите 3 точки для первой ломаной:");
        for (int i = 0; i < 3; i++) {
            points.add(inputPoint(scanner)); // Добавляем точки в общий список
        }


        PolyLine polyLine1 = new PolyLine(points);
        System.out.println("Первая ломаная: " + polyLine1);


        List<Point> pointsForPolyLine2 = new ArrayList<>();


        pointsForPolyLine2.add(points.get(0)); // Первая точка первой ломаной


        System.out.println("Введите 2 точки для второй ломаной (начальная и конечная совпадают с первой):");
        pointsForPolyLine2.add(inputPoint(scanner)); // Ввод точки
        pointsForPolyLine2.add(inputPoint(scanner)); // Ввод точки


        pointsForPolyLine2.add(points.get(2)); // Конечная точка совпадает с последней первой ломаной


        PolyLine polyLine2 = new PolyLine(pointsForPolyLine2);
        System.out.println("Вторая ломаная: " + polyLine2);


        int shiftX = inputInteger(scanner, "Введите сдвиг по X: ");
        int shiftY = inputInteger(scanner, "Введите сдвиг по Y: ");


        polyLine1.shiftStart(shiftX, shiftY);


        System.out.println("Первая ломаная после сдвига: " + polyLine1);
        System.out.println("Вторая ломаная после сдвига: " + polyLine2); // Поскольку первая точка во второй ломаной совпадает с первой, изменения отразятся автоматически.

        scanner.close();
    }
}
