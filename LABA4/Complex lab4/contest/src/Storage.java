import java.util.InputMismatchException;
import java.util.Scanner;

public class Storage<I> {
    private final I item;

    // Стройка
    public Storage(I item) {
        this.item = item;
    }

    // Альтернативы не найдется?
    public I getOrDefault(I alternative) {
        return item != null ? item : alternative;  // Возвращаем объект или альтернативу
    }
    // Метод, принимающий Хранилище и выводящий значение на экран
    public static <I> void AlternativeChoose(Storage<I> storage, I alternative) {
        I value = storage.getOrDefault(alternative);
        System.out.println("Значение: " + value);
    }
    //Метод любящий исключительно циферки
    public static Integer CorrectNum(Scanner scanner) {
        String input = scanner.next();  // Читаем
        if (input.equalsIgnoreCase("null")) {
            return null;  // Если никого нет дома
        }
        try {
            return Integer.parseInt(input);  // Преобразуем строку в число
        } catch (NumberFormatException e) {
            throw new InputMismatchException("Некорректный ввод числа!");  // ЗДЕСЬ БУКВАМ НЕ РАДЫ
        }
    }

    // Метод, который любит null
    public static String CorrectString(Scanner scanner) {
        String input = scanner.next();  // Опять же читаем
        if (input.equalsIgnoreCase("null")) {
            return null;  // Если дома никого
        }
        return input;  // Ну нет так нет, так и запишем
    }
}
