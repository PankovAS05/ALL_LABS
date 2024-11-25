import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class Transformer {


    public static <T, P> List<P> transform(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество строк:");
        int count = Integer.parseInt(scanner.nextLine());
        List<String> strings = new ArrayList<>();
        System.out.println("Введите строки:");
        for (int i = 0; i < count; i++) {
            strings.add(scanner.nextLine());
        }
        List<Integer> lengths = transform(strings, String::length);  // Применяем метод length к строкам
        System.out.println("Длины строк: " + lengths);


        System.out.println("Введите количество чисел:");
        count = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Введите числа:");
        for (int i = 0; i < count; i++) {
            numbers.add(Integer.parseInt(scanner.nextLine()));
        }
        List<Integer> absoluteValues = transform(numbers, Math::abs);  // Применяем метод abs к числам
        System.out.println("Абсолютные значения: " + absoluteValues);


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
        List<Integer> maxValues = transform(arrays, arr -> Arrays.stream(arr).max().orElse(Integer.MIN_VALUE));  // Находим максимум в каждом массиве
        System.out.println("Максимальные значения массивов: " + maxValues);
    }
}
