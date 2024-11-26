package geometry;

import java.util.Arrays;

public class Triangle implements PolygonalChain {
    private Point p1, p2, p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public PolyLine getPolygonalChain() {
        return new PolyLine(Arrays.asList(p1, p2, p3, p1));
    }
}