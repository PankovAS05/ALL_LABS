import java.util.*;
public class ListCheck {
    public static <T> List<T> removeDuplicates(List<T> list) {
        HashSet<T> seen = new HashSet<>(); // Множество для отслеживания уникальных элементов
        List<T> result = new ArrayList<>(); // Результирующий список

        for (T element : list) {
            // Если элемента еще не было в множестве, добавляем его в результат и отмечаем как увиденный
            if (!seen.contains(element)) {
                result.add(element);
                seen.add(element);
            }
        }

        return result; // Возвращаем список без дубликатов
    }

    public static Number readNumber(Scanner scanner) {
        if (scanner.hasNextInt()) {
            return scanner.nextInt(); // Считываем целое число
        } else if (scanner.hasNextDouble()) {
            return scanner.nextDouble(); // Считываем число с плавающей точкой
        } else if (scanner.hasNextFloat()) {
            return scanner.nextFloat();
        } else {
            throw new IllegalArgumentException("Некорректный ввод, ожидалось число");
        }
    }
}
