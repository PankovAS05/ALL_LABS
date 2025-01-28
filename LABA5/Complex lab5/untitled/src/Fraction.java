public class Fraction implements Drobi {
    private Number numerator;
    private Number denominator;
    private Double cachedRealValue;

    // Конструктор
    public Fraction(Number numerator, Number denominator) {
        if (denominator.doubleValue() == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        this.cachedRealValue = null; // Инициализация кэша
    }

    // Метод для получения вещественного значения
    @Override
    public double getRealValue() {
        if (cachedRealValue == null) {
            cachedRealValue = numerator.doubleValue() / denominator.doubleValue();
        }
        return cachedRealValue;
    }

    // Метод для установки числителя
    @Override
    public void setNumerator(Number numerator) {
        this.numerator = numerator;
        invalidateCache();
    }

    // Метод для установки знаменателя
    @Override
    public void setDenominator(Number denominator) {
        if (denominator.doubleValue() == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.denominator = denominator;
        invalidateCache();
    }

    // Метод для инвалидации кэша
    private void invalidateCache() {
        cachedRealValue = null;
    }

    // Геттеры для числителя и знаменателя
    public Number getNumerator() {
        return numerator;
    }

    public Number getDenominator() {
        return denominator;
    }

    // Метод для вывода дроби в виде строки
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }}