package Calculator;

import Geometry.Lengthable;
import java.util.List;


public class LengthCalculator {
    public static double calculateTotalLength(List<Lengthable> objects) {
        double totalLength = 0;
        for (Lengthable object : objects) {
            totalLength += object.getLength();
        }
        return totalLength;
    }
}