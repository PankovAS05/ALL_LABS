import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Methods {
    //dlya 1
    public static <T, P> List<P> apply(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }
    //dlay 2
    public static <T> List<T> test(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {  // Возвращает состояние true or falseeee
                result.add(item);
            }
        }
        return result;}  // Возвращаем новый, прям с пылу с жару отфильтрованный список
    //dlya 3
    public static <T> T recursy(List<T> list, T identity, java.util.function.BinaryOperator<T> accumulator) {
            if (list == null || list.isEmpty()) {
                System.out.println("Список пуст или не был передан, возвращаем начальное значение.");
                return identity;  // Возвращаем начальное значение, если список пуст или null
            }
            return list.stream().reduce(identity, accumulator);  // Выполняем редукцию
        }

        public static int countly(List<List<Integer>> listOfLists) {
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
            return totalCount;}
    //dlya 4
            public static void split(List<Integer> inputList, List<Integer> positiveList, List<Integer> negativeList) {
                for (Integer number : inputList) {
                    if (number > 0) {
                        positiveList.add(number);
                    } else {
                        negativeList.add(number);
                    }
                }
            }


            public static void grouping(List<String> inputList, Map<Integer, List<String>> resultMap) {
                for (String str : inputList) {
                    int length = str.length();
                    if (!resultMap.containsKey(length)) {
                        resultMap.put(length, new ArrayList<>());
                    }
                    resultMap.get(length).add(str);
                }
            }


            public static void duplicates(List<String> inputList, Set<String> resultSet) {
                resultSet.addAll(inputList); // Set автоматически удаляет дубликаты
            }
        }
