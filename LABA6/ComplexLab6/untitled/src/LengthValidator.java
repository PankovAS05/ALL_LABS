public class LengthValidator {
    public static boolean validate(String value, int minLength) {
        return value != null && value.length() >= minLength;
    }
}