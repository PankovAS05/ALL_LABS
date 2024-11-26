package geometry;

public class point {
    private int x;
    private int y;

    // Конструктор
    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Геттеры
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Приведение к строковому виду
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    // Метод для сдвига точки
    public void shift(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    // Метод для вычисления расстояния между двумя точками
    public double distanceTo(point other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
    }
}
