import java.util.*;

class Collector {


    public static void splitPositiveNegative(List<Integer> inputList, List<Integer> positiveList, List<Integer> negativeList) {
        for (Integer number : inputList) {
            if (number > 0) {
                positiveList.add(number);
            } else {
                negativeList.add(number);
            }
        }
    }


    public static void groupByLength(List<String> inputList, Map<Integer, List<String>> resultMap) {
        for (String str : inputList) {
            int length = str.length();
            if (!resultMap.containsKey(length)) {
                resultMap.put(length, new ArrayList<>());
            }
            resultMap.get(length).add(str);
        }
    }


    public static void removeDuplicates(List<String> inputList, Set<String> resultSet) {
        resultSet.addAll(inputList); // Set автоматически удаляет дубликаты
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Введите количество чисел:");
        int numberCount = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Введите числа:");
        for (int i = 0; i < numberCount; i++) {
            numbers.add(scanner.nextInt());
        }

        List<Integer> positiveNumbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();
        splitPositiveNegative(numbers, positiveNumbers, negativeNumbers);

        System.out.println("Положительные числа: " + positiveNumbers);
        System.out.println("Отрицательные числа: " + negativeNumbers);


        scanner.nextLine(); // consume the newline character
        System.out.println("Введите количество строк:");
        int stringCount = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        List<String> strings = new ArrayList<>();
        System.out.println("Введите строки:");
        for (int i = 0; i < stringCount; i++) {
            strings.add(scanner.nextLine());
        }

        Map<Integer, List<String>> groupedStrings = new HashMap<>();
        groupByLength(strings, groupedStrings);

        System.out.println("Группировка строк по длине:");
        for (Map.Entry<Integer, List<String>> entry : groupedStrings.entrySet()) {
            System.out.println("Длина " + entry.getKey() + ": " + entry.getValue());
        }


        System.out.println("Введите количество строк для удаления дубликатов:");
        int stringCount2 = scanner.nextInt();
        scanner.nextLine();
        List<String> strings2 = new ArrayList<>();
        System.out.println("Введите строки:");
        for (int i = 0; i < stringCount2; i++) {
            strings2.add(scanner.nextLine());
        }

        Set<String> uniqueStrings = new HashSet<>();
        removeDuplicates(strings2, uniqueStrings);

        System.out.println("Строки без дубликатов:");
        System.out.println(uniqueStrings);

        scanner.close();
    }
}
