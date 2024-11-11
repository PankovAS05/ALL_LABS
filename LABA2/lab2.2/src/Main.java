import java.util.Scanner;


class Name {
    private String lastName;  // Фамилия
    private String firstName; // Имя
    private String patronymic; // Отчество

    // Конструктор для всех полей
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


    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
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
    private Name name;       // Имя человека
    private int height;      // Рост
    private Person father;   // Отец
    private boolean isMale;  // Пол (true для мужчины, false для женщины)

    // Конструктор для создания человека с указанием имени, роста и пола
    public Person(Name name, int height, boolean isMale) {
        this.name = name;
        this.height = height;
        this.isMale = isMale;
    }


    public void setFather(Person father) {
        this.father = father;
        // Если у человека нет фамилии, устанавливаем фамилию отца
        if (this.name.getLastName() == null && father != null && father.name.getLastName() != null) {
            this.name = new Name(father.name.getLastName(), this.name.getFirstName(), this.name.getPatronymic());
        }

        // Если у человека нет отчества, устанавливаем его как имя отца + суффикс
        if (this.name.getPatronymic() == null && father != null && father.name.getFirstName() != null) {
            this.name = new Name(this.name.getLastName(), this.name.getFirstName(), derivePatronymic(father.name.getFirstName(), this.isMale));
        }
    }


    @Override
    public String toString() {
        return name + ", рост: " + height + (father != null ? ", отец: " + father.name : "");
    }


    private static String derivePatronymic(String fatherFirstName, boolean isMale) {
        if (fatherFirstName.endsWith("й") || fatherFirstName.endsWith("ь")) {
            fatherFirstName = fatherFirstName.substring(0, fatherFirstName.length() - 1) + "ев";
        }
        return fatherFirstName + (isMale ? "ович" : "овна");
    }


    public static int safeHeightInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int height = Integer.parseInt(scanner.nextLine().trim());
                if (height > 0) {
                    return height;
                } else {
                    System.out.println("Ошибка: Рост должен быть положительным числом.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите корректное целое число.");
            }
        }
    }


    public static boolean safeGenderInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + " (м/ж): ");
            String genderInput = scanner.nextLine().trim().toLowerCase();
            if (genderInput.equals("м")) {
                return true;
            } else if (genderInput.equals("ж")) {
                return false;
            } else {
                System.out.println("Ошибка: Введите 'м' для мужчины или 'ж' для женщины.");
            }
        }
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


        Person[] people = new Person[3];
        int count = 0;

        do {

            String firstName = Name.safeInput(scanner, "Введите имя: ");
            while (firstName == null) {
                System.out.println("Ошибка: Имя не может быть пустым. Попробуйте снова.");
                firstName = Name.safeInput(scanner, "Введите имя: ");
            }

            String lastName = Name.safeInput(scanner, "Введите фамилию (оставьте пустым, если нет): ");
            String patronymic = Name.safeInput(scanner, "Введите отчество (оставьте пустым, если нет): ");


            Name name = new Name(lastName, firstName, patronymic);


            int height = Person.safeHeightInput(scanner, "Введите рост: ");


            boolean isMale = Person.safeGenderInput(scanner, "Укажите пол");


            Person person = new Person(name, height, isMale);


            if (count > 0) {
                System.out.print("Укажите индекс отца для данного человека (1-" + (count) + "), или 0 если отца нет: ");
                int fatherIndex = (Integer.parseInt(scanner.nextLine()))-1;
                if (fatherIndex >= 0 && fatherIndex < count) {
                    person.setFather(people[fatherIndex]);
                }
            }


            people[count++] = person;

        } while (count < 3 && askToContinue(scanner));  // Ограничено тремя людьми


        System.out.println("\nВведенные люди:");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
