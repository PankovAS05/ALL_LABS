import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Reducer {

    public static <T> T reduce(List<T> list, T identity, java.util.function.BinaryOperator<T> accumulator) {
        if (list == null || list.isEmpty()) {
            System.out.println("Список пуст или не был передан, возвращаем начальное значение.");
            return identity;  // Возвращаем начальное значение, если список пуст или null
        }
        return list.stream().reduce(identity, accumulator);  // Выполняем редукцию
    }

    public static int countElements(List<List<Integer>> listOfLists) {
        if (listOfLists == null || listOfLists.isEmpty()) {
            System.out.println("Список списков пуст, возвращаем 0.");
            return 0;  // Если список пуст или null, возвращаем 0
        }

        int totalCount = 0;
        for (List<Integer> sublist : listOfLists) {
            if (sublist != null) {
                totalCount += sublist.size(); // Добавляем количество элементов в подсписке
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Пример 1: Сложить все строки в одну
        System.out.println("Введите количество строк:");
        int stringCount = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        List<String> strings = new ArrayList<>();
        if (stringCount > 0) {
            System.out.println("Введите строки:");
            for (int i = 0; i < stringCount; i++) {
                strings.add(scanner.nextLine());
            }
        }
        String concatenatedString = reduce(strings, "", (s1, s2) -> s1 + s2);
        System.out.println("Конкатенированная строка: " + concatenatedString);

        // Пример 2: Найти сумму всех чисел
        System.out.println("Введите количество чисел:");
        int numberCount = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        if (numberCount > 0) {
            System.out.println("Введите числа:");
            for (int i = 0; i < numberCount; i++) {
                numbers.add(scanner.nextInt());
            }
        }
        Integer sum = reduce(numbers, 0, (n1, n2) -> n1 + n2);
        System.out.println("Сумма чисел: " + sum);

        // Пример 3: Подсчитать количество всех элементов в списках
        System.out.println("Введите количество списков целых чисел:");
        int listCount = scanner.nextInt();
        List<List<Integer>> listOfLists = new ArrayList<>();
        if (listCount > 0) {
            System.out.println("Введите списки:");
            for (int i = 0; i < listCount; i++) {
                System.out.println("Введите количество элементов в списке " + (i + 1) + ":");
                int elementCount = scanner.nextInt();
                List<Integer> sublist = new ArrayList<>();
                System.out.println("Введите элементы списка:");
                for (int j = 0; j < elementCount; j++) {
                    sublist.add(scanner.nextInt());
                }
                listOfLists.add(sublist);
            }
        }

        // Подсчет общего количества элементов в списках с помощью нового метода
        int totalCount = countElements(listOfLists);
        System.out.println("Общее количество элементов: " + totalCount);

        scanner.close();
    }
}
