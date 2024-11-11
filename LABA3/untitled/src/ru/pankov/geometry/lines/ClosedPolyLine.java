package ru.pankov.geometry.lines;

public class ClosedPolyLine extends PolyLine {
    @Override
    public double getLength() {
        if (points.size() > 1) {
            // Добавляем длину от последней точки к первой, чтобы линия замкнулась
            return super.getLength() + Math.sqrt(Math.pow(points.get(points.size() - 1).getX() - points.get(0).getX(), 2)
                    + Math.pow(points.get(points.size() - 1).getY() - points.get(0).getY(), 2));
        }
        return 0;
    }
}
