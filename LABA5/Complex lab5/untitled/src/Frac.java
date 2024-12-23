public class Frac implements Drobi {
    private int numerator;   // Числитель
    private int denominator; // Знаменатель
    private Double cacheFrac = null; // Кэшированное вещественное значение

    // Конструктор, который инициализирует дробь
    public Frac(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }

        // Обработка отрицательного знаменателя
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        // Сбросить кэш, если дробь изменена
        this.cacheFrac = null;
    }

    public double getCacheFrac() {
        if (cacheFrac == null) {
            cacheFrac = (double) numerator / denominator;
        }
        return cacheFrac;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        this.cacheFrac = null;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }

        if (denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -denominator;
        } else {
            this.denominator = denominator;
        }
        this.cacheFrac = null;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }


    @Override
    public int hashCode() {
        return 52 * numerator + denominator;
    }
}
