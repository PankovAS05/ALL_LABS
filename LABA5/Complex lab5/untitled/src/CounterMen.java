public class CounterMen {
    private static int count;  // Счетчик мяуканий

    public CounterMen() {
        this.count = 0;
    }

    // Метод для увеличения счетчика
    public void increment() {
        count++;
    }

    // Метод для получения текущего значения счетчика
    public static int getCount() {
        return count;
    }
}
