package geometry;

import java.util.Arrays;

public class Line implements PolygonalChain {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public PolyLine getPolygonalChain() {
        return new PolyLine(Arrays.asList(start, end));
    }

    public double getLength() {
        return start.distanceTo(end);
    }
}