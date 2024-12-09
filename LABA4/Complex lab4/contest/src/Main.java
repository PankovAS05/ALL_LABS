import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите номер задания для его решения:");
        switch (sc.nextLine()) {
            case "1"://Коробка с чем то, и это должно как и лежать там так и доставаться
                try {
                    Box<Integer> integerBox = new Box<>();

                    if (integerBox.isEmpty()) {
                        System.out.println("Коробка пуста.");
                    }

                    System.out.print("Введите число для помещения в коробку: ");
                    int inputValue = sc.nextInt();  // Чтение целого числа с клавиатуры

                    integerBox.put(inputValue);
                    System.out.println("Число " + inputValue + " положено в коробку.");

                    System.out.print("Хотите извлечь значение из коробки? (да/нет): ");
                    String userResponse = sc.next();

                    if (userResponse.equalsIgnoreCase("да")) {
                        Integer extractedValue = integerBox.get();
                        System.out.println("Извлеченное значение: " + extractedValue);
                    } else {
                        System.out.println("Значение остается в коробке.");
                    }
                    if (integerBox.isEmpty()) {
                        System.out.println("Коробка теперь пуста.");
                    } else {
                        System.out.println("Коробка все еще содержит значение: " + integerBox.peek());
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
                break;
            case "2"://Хранилище которое вместо null должно возвращать какую либо альтернативу
                try {
                    // 1. Создаем Хранилище чисел с null и выводим значение (альтернатива: 0)

                    System.out.println("Введите значение для Хранилища чисел :");
                    Integer numberInput = Storage.CorrectNum(sc);
                    Storage<Integer> numberStorageNull = new Storage<>(numberInput);
                    System.out.println("Хранилище чисел с null:");
                    Storage.AlternativeChoose(numberStorageNull, 0);  // Альтернатива: 0

                    // 2. Создаем Хранилище чисел со значением 99 и выводим значение (альтернатива: -1)
                    System.out.println("\nВведите значение для Хранилища чисел :");
                    numberInput = Storage.CorrectNum(sc);
                    Storage<Integer> numberStorage99 = new Storage<>(numberInput);
                    System.out.println("Хранилище чисел со значением:");
                    Storage.AlternativeChoose(numberStorage99, -1);  // Альтернатива: -1

                    // 3. Создаем Хранилище строк с null и выводим значение (альтернатива: "default")
                    System.out.println("\nВведите строку для Хранилища строк:");
                    String stringInput = Storage.CorrectString(sc);
                    Storage<String> stringStorageNull = new Storage<>(stringInput);
                    System.out.println("Хранилище строк с null:");
                    Storage.AlternativeChoose(stringStorageNull, "default");  // Альтернатива: "default"

                    // 4. Создаем Хранилище строк со значением "hello" и выводим значение (альтернатива: "hello world")
                    System.out.println("\nВведите строку для Хранилища строк:");
                    stringInput = Storage.CorrectString(sc);
                    Storage<String> stringStorageHello = new Storage<>(stringInput);
                    System.out.println("Хранилище строк со значением:");
                    Storage.AlternativeChoose(stringStorageHello, "hello world");  // Альтернатива: "hello world"

                } catch (InputMismatchException e) {
                    System.out.println("Ошибка ввода! Пожалуйста, вводите корректные значения.");
                }
                break;
            case "3"://Поиск максимального из n коробок
                List<Box<? extends Number>> boxes = new ArrayList<>();
                try {
                    // Ввод количества коробок
                    System.out.println("Введите количество коробок:");
                    int numberOfBoxes = sc.nextInt();

                    // Для каждой коробки запрашиваем тип данных и значение
                    for (int i = 0; i < numberOfBoxes; i++) {
                        System.out.println("Коробка #" + (i + 1));

                        System.out.println("Выберите тип данных для коробки:");
                        System.out.println("1. Integer (целое число)");
                        System.out.println("2. Double (дробное число)");
                        System.out.println("3. Float (дробное число)");

                        int choice = sc.nextInt();  // Выбор типа данных

                        switch (choice) {
                            case 1: {
                                System.out.println("Введите целое число (Integer):");
                                Integer intValue = sc.nextInt();
                                Box<Integer> intBox = new Box<>();
                                intBox.put(intValue);
                                boxes.add(intBox);
                                break;
                            }
                            case 2: {
                                System.out.println("Введите дробное число (Double):");
                                Double doubleValue = sc.nextDouble();
                                Box<Double> doubleBox = new Box<>();
                                doubleBox.put(doubleValue);
                                boxes.add(doubleBox);
                                break;
                            }
                            case 3: {
                                System.out.println("Введите дробное число (Float):");
                                Float floatValue = sc.nextFloat();
                                Box<Float> floatBox = new Box<>();
                                floatBox.put(floatValue);
                                boxes.add(floatBox);
                                break;
                            }
                            default:
                                System.out.println("Неверный выбор типа данных. Попробуйте снова.");
                                i--;  // Повторяем итерацию для этой коробки
                                break;
                        }
                    }

                    // Вызываем метод для поиска максимального значения
                    double maxValue = Box.FindMax(boxes);
                    System.out.println("Максимальное значение среди коробок: " + maxValue);

                } catch (InputMismatchException e) {
                    System.out.println("Ошибка ввода! Пожалуйста, вводите корректные значения.");
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
                break;
            case "4"://P,T используя входящий метод
                System.out.println("Введите количество строк:");
                int count = Integer.parseInt(sc.nextLine());
                List<String> strings = new ArrayList<>();
                System.out.println("Введите строки:");
                for (int i = 0; i < count; i++) {
                    strings.add(sc.nextLine());
                }
                List<Integer> lengths = Methods.apply(strings, String::length);
                System.out.println("Длины строк: " + lengths);


                System.out.println("Введите количество чисел:");
                count = Integer.parseInt(sc.nextLine());
                List<Integer> numbers = new ArrayList<>();
                System.out.println("Введите числа:");
                for (int i = 0; i < count; i++) {
                    numbers.add(Integer.parseInt(sc.nextLine()));
                }
                List<Integer> absoluteValues = Methods.apply(numbers, Math::abs);  // Применяем метод abs к числам
                System.out.println("Абсолютные значения: " + absoluteValues);


                System.out.println("Введите количество массивов:");
                count = Integer.parseInt(sc.nextLine());
                List<int[]> arrays = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    System.out.println("Введите массив чисел (через пробел):");
                    String[] input = sc.nextLine().split(" ");
                    int[] arr = new int[input.length];
                    for (int j = 0; j < input.length; j++) {
                        arr[j] = Integer.parseInt(input[j]);
                    }
                    arrays.add(arr);
                }
                List<Integer> maxValues = Methods.apply(arrays, arr -> Arrays.stream(arr).max().orElse(Integer.MIN_VALUE));  // Находим максимум в каждом массиве
                System.out.println("Максимальные значения массивов: " + maxValues);
                break;
            case "5"://Т метод использующий boolean
                System.out.println("Введите количество строк:");
                count = Integer.parseInt(sc.nextLine());
                strings = new ArrayList<>();
                System.out.println("Введите строки:");
                for (int i = 0; i < count; i++) {
                    strings.add(sc.nextLine());
                }

                // 3или менее символов
                List<String> filteredStrings = Methods.test(strings, s -> s.length() <= 3);
                System.out.println("Отфильтрованные строки (длина <= 3): " + filteredStrings);


                System.out.println("Введите количество чисел:");
                count = Integer.parseInt(sc.nextLine());
                numbers = new ArrayList<>();
                System.out.println("Введите числа:");
                for (int i = 0; i < count; i++) {
                    numbers.add(Integer.parseInt(sc.nextLine()));
                }

                // ИСКЛЮЧИТЕЛЬНО МИНУС
                List<Integer> filteredNumbers = Methods.test(numbers, n -> n < 0);
                System.out.println("Отфильтрованные числа (отрицательные): " + filteredNumbers);


                System.out.println("Введите количество массивов:");
                count = Integer.parseInt(sc.nextLine());
                arrays = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    System.out.println("Введите массив чисел (через пробел):");
                    String[] input = sc.nextLine().split(" ");
                    int[] arr = new int[input.length];
                    for (int j = 0; j < input.length; j++) {
                        arr[j] = Integer.parseInt(input[j]);
                    }
                    arrays.add(arr);
                }

                // Массивы только с плюсами, минусов и так хватает
                List<int[]> filteredArrays = Methods.test(arrays, arr -> Arrays.stream(arr).noneMatch(x -> x > 0));
                System.out.println("Отфильтрованные массивы (без положительных чисел): ");
                for (int[] arr : filteredArrays) {
                    System.out.println(Arrays.toString(arr));}
                break;
            case "6"://Fail тк использовалось два метода
                System.out.println("Введите количество строк:");
                int stringCount = sc.nextInt();
                sc.nextLine();
                strings = new ArrayList<>();
                if (stringCount > 0) {
                    System.out.println("Введите строки:");
                    for (int i = 0; i < stringCount; i++) {
                        strings.add(sc.nextLine());
                    }
                }
                //Составляем общагу из строк
                String combinedString = Methods.recursy(strings, "", (s1, s2) -> s1 + s2);
                System.out.println("Общая строка: " + combinedString);


                System.out.println("Введите количество чисел:");
                int numberCount = sc.nextInt();
                numbers = new ArrayList<>();
                if (numberCount > 0) {
                    System.out.println("Введите числа:");
                    for (int i = 0; i < numberCount; i++) {
                        numbers.add(sc.nextInt());
                    }
                }
                //Рекурсивный метод суммы чисел
                Integer sum = Methods.recursy(numbers, 0, (n1, n2) -> n1 + n2);
                System.out.println("Сумма чисел: " + sum);

                System.out.println("Введите количество списков целых чисел:");
                int listCount = sc.nextInt();
                List<List<Integer>> listOfLists = new ArrayList<>();
                if (listCount > 0) {
                    System.out.println("Введите списки:");
                    for (int i = 0; i < listCount; i++) {
                        System.out.println("Введите количество элементов в списке " + (i + 1) + ":");
                        int elementCount = sc.nextInt();
                        List<Integer> sublist = new ArrayList<>();
                        System.out.println("Введите элементы списка:");
                        for (int j = 0; j < elementCount; j++) {
                            sublist.add(sc.nextInt());
                        }
                        listOfLists.add(sublist);
                    }
                }
                // Подсчет общего количества элементов в списках с помощью нового метода
                int totalCount = Methods.countly(listOfLists);
                System.out.println("Общее количество элементов: " + totalCount);
                break;
            case "7"://Тотальный Fail тут у каждого набора свой метод
                System.out.println("Введите количество чисел:");
                numberCount = sc.nextInt();
                numbers = new ArrayList<>();
                System.out.println("Введите числа:");
                for (int i = 0; i < numberCount; i++) {
                    numbers.add(sc.nextInt());
                }

                List<Integer> positiveNumbers = new ArrayList<>();
                List<Integer> negativeNumbers = new ArrayList<>();
                Methods.split(numbers, positiveNumbers, negativeNumbers);

                System.out.println("Положительные числа: " + positiveNumbers);
                System.out.println("Отрицательные числа: " + negativeNumbers);


                sc.nextLine(); // consume the newline character
                System.out.println("Введите количество строк:");
                stringCount = sc.nextInt();
                sc.nextLine(); // consume the newline character
                strings = new ArrayList<>();
                System.out.println("Введите строки:");
                for (int i = 0; i < stringCount; i++) {
                    strings.add(sc.nextLine());
                }

                Map<Integer, List<String>> groupedStrings = new HashMap<>();
                Methods.grouping(strings, groupedStrings);

                System.out.println("Группировка строк по длине:");
                for (Map.Entry<Integer, List<String>> entry : groupedStrings.entrySet()) {
                    System.out.println("Длина " + entry.getKey() + ": " + entry.getValue());
                }


                System.out.println("Введите количество строк для удаления дубликатов:");
                int stringCount2 = sc.nextInt();
                sc.nextLine();
                List<String> strings2 = new ArrayList<>();
                System.out.println("Введите строки:");
                for (int i = 0; i < stringCount2; i++) {
                    strings2.add(sc.nextLine());
                }

                Set<String> uniqueStrings = new HashSet<>();
                Methods.duplicates(strings2, uniqueStrings);

                System.out.println("Строки без дубликатов:");
                System.out.println(uniqueStrings);

                sc.close();
        }
    }
}