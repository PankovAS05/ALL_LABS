import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите номер задания для его решения:");
        switch (scan.nextLine()) {
            case "1":
                System.out.print("Введите числитель: ");
                Number numerator = scan.nextDouble();

                System.out.print("Введите знаменатель: ");
                Number denominator = scan.nextDouble();

                Drobi fraction = new Fraction(numerator, denominator);
                System.out.println("Дробь: " + fraction);
                System.out.println("Вещественное значение: " + fraction.getRealValue());

                System.out.print("Введите новый числитель: ");
                numerator = scan.nextDouble();

                System.out.print("Введите новый знаменатель: ");
                denominator = scan.nextDouble();

                fraction.setNumerator(numerator);
                fraction.setDenominator(denominator);
                System.out.println("Обновленная дробь: " + fraction);
                System.out.println("Обновленное вещественное значение: " + fraction.getRealValue());
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
                int miaow = scan.nextInt(); // Читаем количество мяуканий

                // Кот мяукает указанное количество раз
                for (int i = 0; i < miaow; i++) {
                    All_meow.makeThemMeow(new Miukai[]{catWithCounter});
                }

                // Выводим количество мяуканий кота
                System.out.println("Количество мяуканий кота: " + CounterMen.getCount());

                // Используем MeowingHelper для того, чтобы кот мяукал еще раз
                System.out.println("Кот мяукает:");
                All_meow.makeThemMeow(new Miukai[]{catWithCounter});

                // Выводим количество мяуканий кота после работы MeowingHelper
                System.out.println("Количество мяуканий кота: " + CounterMen.getCount());
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
                break;
//            case "4":
//                String filename = "input.txt";
//
//                // Вызываем метод для обработки данных и вывода результатов
//                try {
//                    Map<String, Sportsman> sportsmenMap = Sportsman.readDataFromFile(filename);
//                    Sportsman.processResults(sportsmenMap);
//                } catch (IOException e) {
//                    System.out.println("Ошибка чтения файла: " + e.getMessage());
//                }
//                break;
//            case "5":
//                String filename2 = "input2.txt";
//
//                // Обрабатываем текст
//                try {
//                    String text = SetSymbolFinder.readTextFromFile(filename2);
//                    Set<Character> uniqueChars = SetSymbolFinder.findUniqueCharsInWords(text);
//                    System.out.println("Символы, которые встречаются в одном и только в одном слове:");
//                    for (Character c : uniqueChars) {
//                        System.out.println(c);
//                    }
//                } catch (IOException e) {
//                    System.out.println("Ошибка чтения файла: " + e.getMessage());
//                }
//            default:
//                System.out.println("Данного задания не существует");
//                break;

        }
    }
}