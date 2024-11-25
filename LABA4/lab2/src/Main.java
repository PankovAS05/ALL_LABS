import java.util.InputMismatchException;
import java.util.Scanner;

// Обобщенный неизменяемый класс Хранилище
class Storage<T> {
    private final T item;  // Хранимый объект, который не может быть изменен

    // Конструктор, который принимает объект при создании
    public Storage(T item) {
        this.item = item;
    }

    // Метод для получения объекта с альтернативным значением, если объект = null
    public T getOrDefault(T alternative) {
        return item != null ? item : alternative;  // Возвращаем объект или альтернативу
    }

    // Метод, принимающий Хранилище и выводящий значение на экран
    public static <T> void processStorage(Storage<T> storage, T alternative) {
        T value = storage.getOrDefault(alternative);
        System.out.println("Значение: " + value);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // 1. Создаем Хранилище чисел с null и выводим значение (альтернатива: 0)
            System.out.println("Введите значение для Хранилища чисел :");
            Integer numberInput = getInputIntegerOrNull(scanner);
            Storage<Integer> numberStorageNull = new Storage<>(numberInput);
            System.out.println("Хранилище чисел с null:");
            processStorage(numberStorageNull, 0);  // Альтернатива: 0

            // 2. Создаем Хранилище чисел со значением 99 и выводим значение (альтернатива: -1)
            System.out.println("\nВведите значение для Хранилища чисел :");
            numberInput = getInputIntegerOrNull(scanner);
            Storage<Integer> numberStorage99 = new Storage<>(numberInput);
            System.out.println("Хранилище чисел со значением:");
            processStorage(numberStorage99, -1);  // Альтернатива: -1

            // 3. Создаем Хранилище строк с null и выводим значение (альтернатива: "default")
            System.out.println("\nВведите строку для Хранилища строк:");
            String stringInput = getInputStringOrNull(scanner);
            Storage<String> stringStorageNull = new Storage<>(stringInput);
            System.out.println("Хранилище строк с null:");
            processStorage(stringStorageNull, "default");  // Альтернатива: "default"

            // 4. Создаем Хранилище строк со значением "hello" и выводим значение (альтернатива: "hello world")
            System.out.println("\nВведите строку для Хранилища строк:");
            stringInput = getInputStringOrNull(scanner);
            Storage<String> stringStorageHello = new Storage<>(stringInput);
            System.out.println("Хранилище строк со значением:");
            processStorage(stringStorageHello, "hello world");  // Альтернатива: "hello world"

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода! Пожалуйста, вводите корректные значения.");
        } finally {
            scanner.close();  // Закрываем Scanner
        }
    }

    // Метод для ввода числа, допускающий ввод null
    public static Integer getInputIntegerOrNull(Scanner scanner) {
        String input = scanner.next();  // Чтение ввода в виде строки
        if (input.equalsIgnoreCase("null")) {
            return null;  // Возвращаем null, если введено "null"
        }
        try {
            return Integer.parseInt(input);  // Преобразуем строку в число
        } catch (NumberFormatException e) {
            throw new InputMismatchException("Некорректный ввод числа!");  // Если введено не число
        }
    }

    // Метод для ввода строки, допускающий ввод null
    public static String getInputStringOrNull(Scanner scanner) {
        String input = scanner.next();  // Чтение ввода в виде строки
        if (input.equalsIgnoreCase("null")) {
            return null;  // Возвращаем null, если введено "null"
        }
        return input;  // Возвращаем строку как есть
    }
}
