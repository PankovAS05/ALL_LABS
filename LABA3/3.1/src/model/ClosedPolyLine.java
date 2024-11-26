package model;

import java.util.List;

public class ClosedPolyLine extends PolyLine {

    public ClosedPolyLine(List<Point> points) {
        super(points);
    }

    @Override
    public double length() {
        double totalLength = super.length();
        if (points.size() > 1) {
            totalLength += points.get(points.size() - 1).distanceTo(points.get(0));
        }
        return totalLength;
    }

    @Override
    public String toString() {
        return "Замкнутая " + super.toString();
    }
}
