package line;

import geometry.point;
import java.util.ArrayList;
import java.util.List;

// Класс PolyLine для представления ломаной линии
public class PolyLine {
    private List<point> points;

    // Конструктор
    public PolyLine() {
        this.points = new ArrayList<>();
    }

    // Конструктор с параметрами
    public PolyLine(List<point> points) {
        this.points = points;
    }

    // Метод для добавления точки
    public void addPoint(point point) {
        points.add(point);
    }

    // Метод для получения всех точек
    public List<point> getPoints() {
        return points;
    }

    // Метод для вычисления длины ломаной
    public double getLength() {
        double length = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            length += points.get(i).distanceTo(points.get(i + 1));
        }
        return length;
    }

    // Приведение к строковому виду
    @Override
    public String toString() {
        return "Линия " + points.toString();
    }
}