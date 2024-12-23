import java.lang.reflect.Field;
@Default(value = String.class)
public class Example {
    @Invoke
    public void invokeMethod() {
        System.out.println("Метод с аннотацией @Invoke был вызван.");
    }

    public void anotherMethod() {
        System.out.println("Это обычный метод.");
    }
    @Default(value = Integer.class)
    private Object someField;

    public Example() {
        try {
            Field field = this.getClass().getDeclaredField("someField");
            if (field.isAnnotationPresent(Default.class)) {
                Default annotation = field.getAnnotation(Default.class);
                Class<?> clazz = annotation.value();


                if (clazz == Integer.class) {
                    someField = 0;  // Значение по умолчанию для Integer
                } else if (clazz == Double.class) {
                    someField = 0.0;  // Значение по умолчанию для Double
                } else if (clazz == Boolean.class) {
                    someField = false;  // Значение по умолчанию для Boolean
                } else {
                    someField = clazz.getDeclaredConstructor().newInstance();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getSomeField() {
        return someField;
    }
}
