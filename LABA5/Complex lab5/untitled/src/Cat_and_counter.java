public class Cat_and_counter implements Miukai {
    private Cat cat;            // Объект кота
    private CounterMen counter; // Счетчик мяуканий

    public Cat_and_counter(Cat cat, CounterMen counter) {
        this.cat = cat;
        this.counter = counter;
    }

    @Override
    public void meow() {
        cat.meow();
        counter.meow();
    }
}

