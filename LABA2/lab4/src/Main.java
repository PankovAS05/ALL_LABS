import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Point {
    private int x;
    private int y;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    // Геттеры
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }


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
    private List<Point> points;

    // Конструктор без параметров
    public PolyLine() {
        this.points = new ArrayList<>();
    }

    // Конструктор с параметрами
    public PolyLine(List<Point> points) {
        this.points = points;
    }


    public void addPoint(Point point) {
        points.add(point);
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


    public static String inputYesNo(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("да") || input.equals("нет")) {
                return input;
            }
            System.out.println("Ошибка: введите 'да' или 'нет'. Попробуйте снова.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание первой ломаной
        PolyLine polyLine1 = new PolyLine(); // Создаем пустую ломаную
        System.out.println("Введите количество точек для первой ломаной:");
        int numPoints1 = inputInteger(scanner, "Количество точек: ");
        for (int i = 0; i < numPoints1; i++) {
            polyLine1.addPoint(inputPoint(scanner)); // Добавляем точки
        }
        System.out.println("Первая ломаная: " + polyLine1);

        
        PolyLine polyLine2 = new PolyLine(); // Создаем пустую ломаную
        System.out.println("Введите количество точек для второй ломаной:");
        int numPoints2 = inputInteger(scanner, "Количество точек: ");
        for (int i = 0; i < numPoints2; i++) {
            polyLine2.addPoint(inputPoint(scanner)); // Добавляем точки
        }
        System.out.println("Вторая ломаная: " + polyLine2);


        String response = inputYesNo(scanner, "Хотите ли вы переместить первую точку ломаной? (да/нет): ");

        if (response.equals("да")) {
            int shiftX = inputInteger(scanner, "Введите сдвиг по X: ");
            int shiftY = inputInteger(scanner, "Введите сдвиг по Y: ");
            polyLine1.shiftStart(shiftX, shiftY);
            System.out.println("Первая ломаная после сдвига: " + polyLine1);
            System.out.println("Первая ломаная после сдвига: " + polyLine2);
        } else {
            System.out.println("Сдвиг не выполнен.");
        }

        scanner.close();
    }
}
