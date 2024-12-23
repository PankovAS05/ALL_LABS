public class Cat implements Miukai{
    private String name; // Имя кота

    // Конструктор, принимающий имя кота
    public Cat(String name) {
        this.name = name;
    }

    // Метод для получения текстового представления кота
    @Override
    public String toString() {
        return "кот: " + name;
    }

    // Метод мяуканья, выводит "Имя: мяу!"
    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
    }
}
