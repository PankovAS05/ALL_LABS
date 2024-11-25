import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

class Filterer {

    // Универсальный метод фильтрации
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {  // Применяем метод test, который возвращает boolean
                result.add(item);  // Если test() вернуло true, добавляем элемент в новый список
            }
        }
        return result;  // Возвращаем новый отфильтрованный список
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод списка строк
        System.out.println("Введите количество строк:");
        int count = Integer.parseInt(scanner.nextLine());
        List<String> strings = new ArrayList<>();
        System.out.println("Введите строки:");
        for (int i = 0; i < count; i++) {
            strings.add(scanner.nextLine());
        }

        // Фильтрация строк: оставляем только те, которые имеют 3 или более символов
        List<String> filteredStrings = filter(strings, s -> s.length() <= 3);
        System.out.println("Отфильтрованные строки (длина <= 3): " + filteredStrings);

        // Ввод списка чисел
        System.out.println("Введите количество чисел:");
        count = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Введите числа:");
        for (int i = 0; i < count; i++) {
            numbers.add(Integer.parseInt(scanner.nextLine()));
        }

        // Фильтрация чисел: оставляем только отрицательные числа
        List<Integer> filteredNumbers = filter(numbers, n -> n < 0);
        System.out.println("Отфильтрованные числа (отрицательные): " + filteredNumbers);

        // Ввод списка массивов целых чисел
        System.out.println("Введите количество массивов:");
        count = Integer.parseInt(scanner.nextLine());
        List<int[]> arrays = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.println("Введите массив чисел (через пробел):");
            String[] input = scanner.nextLine().split(" ");
            int[] arr = new int[input.length];
            for (int j = 0; j < input.length; j++) {
                arr[j] = Integer.parseInt(input[j]);
            }
            arrays.add(arr);
        }

        // Фильтрация массивов: оставляем только те, которые не содержат положительных чисел
        List<int[]> filteredArrays = filter(arrays, arr -> Arrays.stream(arr).noneMatch(x -> x > 0));
        System.out.println("Отфильтрованные массивы (без положительных чисел): ");
        for (int[] arr : filteredArrays) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
