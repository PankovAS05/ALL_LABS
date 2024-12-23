import java.util.*;
import java.lang.reflect.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите номер задания: ");
        switch(sc.nextLine()) {
            case "1":
                C b = new C();
                System.out.println(b);
                break;
            case "2.1":
                Example example = new Example();

                // Получаем все методы класса ExampleClass
                Method[] methods = Example.class.getDeclaredMethods();

                for (Method method : methods) {
                    if (method.isAnnotationPresent(Invoke.class)) {
                        try {
                            // Вызываем метод
                            method.invoke(example);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case "2.2":
                Example example2 = new Example();
                if (Example.class.isAnnotationPresent(Default.class)) {
                    Default defaultAnnotation = Example.class.getAnnotation(Default.class);
                    System.out.println("Аннотация @Default на классе имеет значение: " + defaultAnnotation.value().getName());
                }
                else System.out.println("Аннотации нет");

                // Проверяем аннотацию на поле someField
                try {
                    Field field = Example.class.getDeclaredField("someField");

                    if (field.isAnnotationPresent(Default.class)) {
                        Default fieldAnnotation = field.getAnnotation(Default.class);
                        System.out.println("Аннотация @Default на поле someField имеет значение: " + fieldAnnotation.value().getName());
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

                // Вывод значения поля
                System.out.println("Значение поля someField: " + example2.getSomeField());
                break;
            case "2.3":
                Person person = new Person("John Doe", "mySecret123", 30);

                // Выводим строковое представление объекта
                System.out.println(person);
                break;
            case "2.4":
                Person user = new Person("John", null, 25);

                // Проверяем наличие аннотации @Validate на классе
                if (Person.class.isAnnotationPresent(Validate.class)) {
                    Validate validateAnnotation = Person.class.getAnnotation(Validate.class);

                    // Получаем классы валидаторов из аннотации
                    Class<?>[] validators = validateAnnotation.value();

                    for (Class<?> validator : validators) {
                        try {
                            if (validator == NotNullValidator.class) {
                                Method validateMethod = validator.getMethod("validate", Object.class);
                                boolean isValid = (boolean) validateMethod.invoke(null, user.getName());
                                System.out.println(validator.getSimpleName() + ": " + (isValid ? "Valid" : "Invalid"));

                            } else if (validator == LengthValidator.class) {
                                Method validateMethod = validator.getMethod("validate", String.class, int.class);
                                boolean isValid = (boolean) validateMethod.invoke(null, user.getName(), 1);  // Передаем минимальную длину = 5
                                System.out.println(validator.getSimpleName() + ": " + (isValid ? "Valid" : "Invalid"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case "2.5":
                // Проверяем наличие аннотации @Two на классе ExampleClass
                if (Person.class.isAnnotationPresent(Two.class)) {
                    // Получаем аннотацию @Two
                    Two twoAnnotation = Person.class.getAnnotation(Two.class);

                    // Выводим значения свойств аннотации
                    System.out.println("Text bar: " + twoAnnotation.first());
                    System.out.println("Try: " + twoAnnotation.second());
                } else {
                    System.out.println("Аннотация @Two не найдена.");
                }
                break;
            case "2.6":
                // Проверяем наличие аннотации @Cache на классе CachedService
                if (CashUtlity.class.isAnnotationPresent(Cache.class)) {
                    // Получаем аннотацию
                    Cache cacheAnnotation = CashUtlity.class.getAnnotation(Cache.class);

                    // Получаем значения свойства value
                    String[] cacheValues = cacheAnnotation.value();

                    // Если массив не пустой, выводим значения
                    if (cacheValues.length > 0) {
                        System.out.println("Cache values: ");
                        for (String value : cacheValues) {
                            System.out.println("- " + value);
                        }
                    } else {
                        System.out.println("No cache values specified.");
                    }
                } else {
                    System.out.println("Аннотация @Cache не найдена.");
                }
                break;
        }
    }
}