package geometry;

import java.util.Arrays;

public class Square implements PolygonalChain {
    private Point topLeft;
    private double sideLength;

    public Square(Point topLeft, double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Сторона квадрата должна быть положительной.");
        }
        this.topLeft = topLeft;
        this.sideLength = sideLength;
    }

    @Override
    public PolyLine getPolygonalChain() {
        Point topRight = new Point(topLeft.x + sideLength, topLeft.y);
        Point bottomLeft = new Point(topLeft.x, topLeft.y - sideLength);
        Point bottomRight = new Point(topLeft.x + sideLength, topLeft.y - sideLength);
        return new PolyLine(Arrays.asList(topLeft, topRight, bottomRight, bottomLeft, topLeft));
    }
}