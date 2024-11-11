import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lab1 {
    static class Name {
        private String lastName;  // Фамилия
        private String firstName; // Имя
        private String patronymic; // Отчество

        // Конструктор для всех полей
        public Name(String lastName, String firstName, String patronymic) {
            this.lastName = validateInput(lastName);
            this.firstName = validateInput(firstName);
            this.patronymic = validateInput(patronymic);
        }

        // Конструктор для случая, если отчество не задано
        public Name(String lastName, String firstName) {
            this(lastName, firstName, null);
        }

        // Конструктор для случая, если задано только имя
        public Name(String firstName) {
            this(null, firstName, null);
        }

        // Приведение к строковому виду
        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();

            if (lastName != null) {
                result.append(lastName);
            }

            if (firstName != null) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(firstName);
            }

            if (patronymic != null) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(patronymic);
            }

            return result.toString();
        }

        // Метод для проверки корректности ввода (убираем пустую строку и пробелы)
        private static String validateInput(String input) {
            if (input != null && input.trim().isEmpty()) {
                return null;
            }
            return input != null ? input.trim() : null;
        }

        // Метод для безопасного ввода строки с клавиатуры
        private static String safeInput(Scanner scanner, String prompt) {
            System.out.print(prompt);
            return validateInput(scanner.nextLine());
        }

        // Метод для проверки, хочет ли пользователь продолжить ввод
        private static boolean askToContinue(Scanner scanner) {
            while (true) {
                System.out.print("Хотите добавить еще одно имя? (да/нет): ");
                String answer = scanner.nextLine().trim().toLowerCase();
                if (answer.equals("да")) {
                    return true;
                } else if (answer.equals("нет")) {
                    return false;
                } else {
                    System.out.println("Ошибка: Пожалуйста, введите 'да' или 'нет'.");
                }
            }
        }

        // Тестирование программы с вводом данных с клавиатуры
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<Name> names = new ArrayList<>();

            do {
                // Ввод имени, фамилии и отчества
                String firstName = safeInput(scanner, "Введите имя: ");
                while (firstName == null) {
                    System.out.println("Ошибка: Имя не может быть пустым. Попробуйте снова.");
                    firstName = safeInput(scanner, "Введите имя: ");
                }

                String lastName = safeInput(scanner, "Введите фамилию (оставьте пустым, если нет): ");
                String patronymic = safeInput(scanner, "Введите отчество (оставьте пустым, если нет): ");

                // Создание объекта Name на основе введенных данных
                Name name;
                if (lastName != null && patronymic != null) {
                    name = new Name(lastName, firstName, patronymic);
                } else if (lastName != null) {
                    name = new Name(lastName, firstName);
                } else {
                    name = new Name(firstName);
                }

                // Добавление имени в список
                names.add(name);

            } while (askToContinue(scanner));

            // Вывод всех введенных имен
            System.out.println("\nВведенные имена:");
            for (Name name : names) {
                System.out.println(name);
            }
        }
    }
}