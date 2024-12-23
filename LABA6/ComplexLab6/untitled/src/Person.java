import java.lang.reflect.*;

@ToString  //YES
@Validate({NotNullValidator.class, LengthValidator.class})
@Two(first = "Get up, Samurai", second = 8)
public class Person {

    @ToString(value = false)  //NO
    private String password;

    //@ToString  //YES
    private String name;

    private int age;//default YES

    public Person(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = this.password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Class<?> objClass = this.getClass();

        if (objClass.isAnnotationPresent(ToString.class)) {
            Field[] fields = objClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(ToString.class)) {
                    ToString annotation = field.getAnnotation(ToString.class);
                    if (annotation.value() == true) {
                        try {
                            result.append(field.getName())
                                    .append("=")
                                    .append(field.get(this))
                                    .append(", ");
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    try {
                        result.append(field.getName())
                                .append("=")
                                .append(field.get(this))
                                .append(", ");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result.toString();
    }
}