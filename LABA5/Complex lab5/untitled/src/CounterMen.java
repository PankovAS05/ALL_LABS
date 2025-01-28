public class CounterMen {
    private static int count;  // Счетчик мяуканий

    public CounterMen() {
        this.count = 0;
    }


    public void meow() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}
