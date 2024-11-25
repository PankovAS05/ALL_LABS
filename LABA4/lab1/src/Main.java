import java.util.Scanner;

class Box<T> {
    private T item;  // Внутренний объект, который хранится в коробке


    public void put(T item) throws Exception {
        if (this.item != null) {  // Проверка на то, что коробка не пуста
            throw new Exception("Коробка уже заполнена!");
        }
        this.item = item;  // Кладем объект в коробку
    }


    public T get() {
        T temp = item;
        item = null;
        return temp;
    }


    public boolean isEmpty() {
        return item == null;
    }


    public T peek() {
        return item;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Создаем объект Scanner для ввода с клавиатуры

        try {
            Box<Integer> integerBox = new Box<>();

            if (integerBox.isEmpty()) {
                System.out.println("Коробка пуста.");
            }

            System.out.print("Введите число для помещения в коробку: ");
            int inputValue = scanner.nextInt();  // Чтение целого числа с клавиатуры

            integerBox.put(inputValue);
            System.out.println("Число " + inputValue + " положено в коробку.");

            System.out.print("Хотите извлечь значение из коробки? (да/нет): ");
            String userResponse = scanner.next();

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
        } finally {
            scanner.close();
        }
    }
}
