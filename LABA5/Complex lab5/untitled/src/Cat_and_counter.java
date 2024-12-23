public class Cat_and_counter implements Miukai {
    private Cat cat;            // Объект кота
    private CounterMen counter; // Счетчик мяуканий

    // Конструктор, принимающий кота и счетчик
    public Cat_and_counter(Cat cat, CounterMen counter) {
        this.cat = cat;
        this.counter = counter;
    }

    // Метод мяуканья, который увеличивает счетчик мяуканий
    @Override
    public void meow() {
        cat.meow();       // Вызываем мяуканье у настоящего кота
        counter.increment(); // Увеличиваем счетчик мяуканий
    }
}

class MeowingHelper {
    public static void makeThemMeow(Miukai[] meowingObjects) {
        for (Miukai miukai : meowingObjects) {
            miukai.meow();  // Вызываем мяуканье у каждого объекта
        }
    }
}
