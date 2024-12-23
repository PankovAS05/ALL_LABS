import java.lang.reflect.*;
public class Entity {
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Class<?> objClass = this.getClass();

        result.append("{");

        boolean classAnnotatedAsNo = objClass.isAnnotationPresent(ToString.class) &&
                objClass.getAnnotation(ToString.class).value() == false;

        while (objClass != null) {
            Field[] fields = objClass.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);

                ToString toStringAnnotation = field.getAnnotation(ToString.class);
                boolean includeField = true;


                if (toStringAnnotation != null && toStringAnnotation.value() == false) {
                    includeField = false;
                }

                if (classAnnotatedAsNo && (toStringAnnotation == null || toStringAnnotation.value() != false)) {
                    includeField = false;
                }


                if (includeField) {
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

            objClass = objClass.getSuperclass();
        }

        if (result.length() > 2) {
            result.setLength(result.length() - 2); // Убираем последнюю запятую и пробел
        }

        result.append("}");
        return result.toString();
    }
}
