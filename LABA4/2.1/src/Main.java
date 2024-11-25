import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


class Box<T> {
    private T item;


    public void put(T item) throws Exception {
        if (this.item != null) {
            throw new Exception("Коробка уже заполнена!");
        }
        this.item = item;
    }


    public T peek() {
        return item;
    }


    public boolean isEmpty() {
        return item == null;
    }


    public static double findMaxValue(List<Box<? extends Number>> boxes) {
        double maxValue = Double.MIN_VALUE;  // Начальное значение для сравнения


        for (Box<? extends Number> box : boxes) {
            Number value = box.peek();  // Получаем значение из коробки
            if (value != null) {  // Если коробка не пуста
                double doubleValue = value.doubleValue();  // Преобразуем значение к типу double
                if (doubleValue > maxValue) {
                    maxValue = doubleValue;  // Обновляем максимальное значение
                }
            }
        }

        return maxValue;  // Возвращаем максимальное значение
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Box<? extends Number>> boxes = new ArrayList<>();  // Список коробок

        try {
            // Ввод количества коробок
            System.out.println("Введите количество коробок:");
            int numberOfBoxes = scanner.nextInt();

            // Для каждой коробки запрашиваем тип данных и значение
            for (int i = 0; i < numberOfBoxes; i++) {
                System.out.println("Коробка #" + (i + 1));

                System.out.println("Выберите тип данных для коробки:");
                System.out.println("1. Integer (целое число)");
                System.out.println("2. Double (дробное число)");
                System.out.println("3. Float (дробное число)");

                int choice = scanner.nextInt();  // Выбор типа данных

                switch (choice) {
                    case 1: {
                        System.out.println("Введите целое число (Integer):");
                        Integer intValue = scanner.nextInt();
                        Box<Integer> intBox = new Box<>();
                        intBox.put(intValue);
                        boxes.add(intBox);
                        break;
                    }
                    case 2: {
                        System.out.println("Введите дробное число (Double):");
                        Double doubleValue = scanner.nextDouble();
                        Box<Double> doubleBox = new Box<>();
                        doubleBox.put(doubleValue);
                        boxes.add(doubleBox);
                        break;
                    }
                    case 3: {
                        System.out.println("Введите дробное число (Float):");
                        Float floatValue = scanner.nextFloat();
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
            double maxValue = findMaxValue(boxes);
            System.out.println("Максимальное значение среди коробок: " + maxValue);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода! Пожалуйста, вводите корректные значения.");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();  // Закрываем Scanner
        }
    }
}
