package util;

import geometry.*;
import java.util.List;
import java.util.ArrayList;

public class GeometryUtil {

    // Метод для объединения ломаных линий
    public static PolyLine combinePolygonalChains(List<PolygonalChain> chains) {
        List<Point> combinedPoints = new ArrayList<>();

        for (PolygonalChain chain : chains) {
            PolyLine polyLine = chain.getPolygonalChain();
            combinedPoints.addAll(polyLine.points);
        }

        return new PolyLine(combinedPoints);
    }
}