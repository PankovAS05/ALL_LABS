import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Name {
    private String lastName;  // Фамилия
    private String firstName; // Имя
    private String patronymic; // Отчество


    public Name(String lastName, String firstName, String patronymic) {
        this.lastName = validateInput(lastName);
        this.firstName = validateInput(firstName);
        this.patronymic = validateInput(patronymic);
    }


    public Name(String lastName, String firstName) {
        this(lastName, firstName, null);
    }


    public Name(String firstName) {
        this(null, firstName, null);
    }


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


    private static String validateInput(String input) {
        if (input != null && input.trim().isEmpty()) {
            return null;
        }
        return input != null ? input.trim() : null;
    }


    public static String safeInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return validateInput(scanner.nextLine());
    }
}


class Person {
    private Name name;   // Объект класса Name
    private int height;  // Рост

    public Person(Name name, int height) {
        this.name = name;
        this.height = height;
    }


    @Override
    public String toString() {
        return name + ", рост: " + height;
    }
}

public class Main {

    private static boolean askToContinue(Scanner scanner) {
        while (true) {
            System.out.print("Хотите добавить еще одного человека? (да/нет): ");
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        do {

            String firstName = Name.safeInput(scanner, "Введите имя: ");
            while (firstName == null) {
                System.out.println("Ошибка: Имя не может быть пустым. Попробуйте снова.");
                firstName = Name.safeInput(scanner, "Введите имя: ");
            }

            String lastName = Name.safeInput(scanner, "Введите фамилию (оставьте пустым, если нет): ");
            String patronymic = Name.safeInput(scanner, "Введите отчество (оставьте пустым, если нет): ");


            Name name;
            if (lastName != null && patronymic != null) {
                name = new Name(lastName, firstName, patronymic);
            } else if (lastName != null) {
                name = new Name(lastName, firstName);
            } else {
                name = new Name(firstName);
            }


            int height = 0;
            while (true) {
                try {
                    System.out.print("Введите рост: ");
                    height = Integer.parseInt(scanner.nextLine().trim());
                    if (height > 0) {
                        break;
                    } else {
                        System.out.println("Ошибка: Рост должен быть положительным числом.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: Введите корректное целое число для роста.");
                }
            }


            Person person = new Person(name, height);


            people.add(person);

        } while (askToContinue(scanner));


        System.out.println("\nВведенные люди:");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
