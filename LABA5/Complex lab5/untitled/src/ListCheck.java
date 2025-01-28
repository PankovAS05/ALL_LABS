import java.util.*;
public class ListCheck {
    public static <T> List<T> removeDuplicates(List<T> list) {
        List<T> seen = new ArrayList<>(); // Множество для отслеживания уникальных элементов
        List<T> result = new ArrayList<>(); // Результирующий список

        for (T element : list) {
            if (!seen.contains(element)) {
                result.add(element);
                seen.add(element);
            }
        }

        return result;
    }

    public static Number readNumber(Scanner scanner) {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else if (scanner.hasNextFloat()) {
            return scanner.nextFloat();
        } else {
            throw new IllegalArgumentException("Некорректный ввод, ожидалось число");
        }
    }
}
