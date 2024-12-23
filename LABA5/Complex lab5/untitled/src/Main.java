import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите номер задания для его решения:");
        switch (scan.nextLine()) {
            case "1":
                // Создание HashMap для хранения дробей
                Map<Frac, String> fractionMap = new HashMap<>();

                // Ввод числителя и знаменателя с клавиатуры
                System.out.print("Введите числитель для первой дроби: ");
                int numerator1 = scan.nextInt();
                System.out.print("Введите знаменатель для первой дроби: ");
                int denominator1 = scan.nextInt();
                Frac fraction1 = new Frac(numerator1, denominator1);

                // Добавление первой дроби в HashMap
                fractionMap.put(fraction1, "Первая дробь");

                // Ввод числителя и знаменателя для второй дроби
                System.out.print("Введите числитель для второй дроби: ");
                int numerator2 = scan.nextInt();
                System.out.print("Введите знаменатель для второй дроби: ");
                int denominator2 = scan.nextInt();
                Frac fraction2 = new Frac(numerator2, denominator2);

                // Добавление второй дроби в HashMap
                fractionMap.put(fraction2, "Вторая дробь");

                // Вывод содержимого HashMap
                System.out.println("Введенные дроби:");
                for (Map.Entry<Frac, String> entry : fractionMap.entrySet()) {
                    System.out.println(entry.getKey() + " = " + entry.getValue());
                }

                // Проверка на наличие дроби в HashMap
                System.out.print("Введите числитель для поиска: ");
                int searchNumerator = scan.nextInt();
                System.out.print("Введите знаменатель для поиска: ");
                int searchDenominator = scan.nextInt();
                Frac searchFraction = new Frac(searchNumerator, searchDenominator);

                if (fractionMap.containsKey(searchFraction)) {
                    System.out.println("Найдена дробь: " + searchFraction + " = " + fractionMap.get(searchFraction));
                } else {
                    System.out.println("Дробь не найдена.");
                }
            case "2":
                System.out.print("Введите имя кота: ");
                String catName = scan.nextLine(); // Читаем имя кота

                // Создание объекта кота
                Cat cat = new Cat(catName);

                // Создание объекта счетчика
                CounterMen counter = new CounterMen();

                // Создание обертки для кота, которая отслеживает мяуканья
                Cat_and_counter catWithCounter = new Cat_and_counter(cat, counter);

                // Запрашиваем у пользователя количество раз, которое кот должен мяукать
                System.out.print("Сколько раз кот должен мяукать? ");
                int meowCount = scan.nextInt(); // Читаем количество мяуканий

                // Кот мяукает указанное количество раз
                for (int i = 0; i < meowCount; i++) {
                    catWithCounter.meow();
                }

                // Выводим количество мяуканий кота
                System.out.println("Количество мяуканий кота: " + CounterMen.getCount());

                // Используем MeowingHelper для того, чтобы кот мяукал еще раз
                System.out.println("С помощью MeowingHelper кот мяукает:");
                All_meow.makeThemMeow(new Miukai[]{catWithCounter});

                // Выводим количество мяуканий кота после работы MeowingHelper
                System.out.println("Количество мяуканий кота после работы MeowingHelper: " + CounterMen.getCount());
                break;
            case "3":
                // Считываем количество элементов в списке
                System.out.print("Введите количество элементов в списке: ");
                int n = scan.nextInt();


                // Создаем список и считываем его элементы
                List<Number> list = new ArrayList<>();
                System.out.println("Введите элементы списка:");
                for (int i = 0; i < n; i++) {
                    list.add(ListCheck.readNumber(scan));
                }

                // Оставляем только первые вхождения элементов
                List<Number> resultList = ListCheck.removeDuplicates(list);

                // Выводим результат
                System.out.println("Список после удаления дубликатов:");
                for (Number element : resultList) {
                    System.out.print(element + " ");
                }
            case "4":
                String filename = "input.txt";

                // Вызываем метод для обработки данных и вывода результатов
                try {
                    Map<String, Sportsman> sportsmenMap = Sportsman.readDataFromFile(filename);
                    Sportsman.processResults(sportsmenMap);
                } catch (IOException e) {
                    System.out.println("Ошибка чтения файла: " + e.getMessage());
                }
            case "5":
                String filename2 = "input2.txt";

                // Обрабатываем текст
                try {
                    String text = SetSymbolFinder.readTextFromFile(filename2);
                    Set<Character> uniqueChars = SetSymbolFinder.findUniqueCharsInWords(text);
                    System.out.println("Символы, которые встречаются в одном и только в одном слове:");
                    for (Character c : uniqueChars) {
                        System.out.println(c);
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка чтения файла: " + e.getMessage());
                }
            default:
                System.out.println("Данного задания не существует");
                break;

        }
    }
}