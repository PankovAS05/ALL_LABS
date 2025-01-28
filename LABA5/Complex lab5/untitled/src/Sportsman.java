import java.io.*;
import java.util.*;
public class Sportsman {
    private String fullName;  // Полное имя (Фамилия + Имя)
    private int totalScore;   // Сумма баллов
    private int place;        // Место

    public Sportsman(String fullName, int totalScore) {
        this.fullName = fullName;
        this.totalScore = totalScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return fullName + " " + totalScore + " " + place;
    }
    public static void processResults(Map<String, Sportsman> sportsmenMap) {
        Map<String, Sportsman> sortedMap = new LinkedHashMap<>();

        sportsmenMap.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getTotalScore(), e1.getValue().getTotalScore()))
                .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));

        int currentPlace = 1;
        Iterator<Map.Entry<String, Sportsman>> iterator = sortedMap.entrySet().iterator();
        if (iterator.hasNext()) {
            Map.Entry<String, Sportsman> firstEntry = iterator.next();
            Sportsman firstSportsman = firstEntry.getValue();
            firstSportsman.setPlace(currentPlace);
        }

        int prevScore = sortedMap.entrySet().iterator().next().getValue().getTotalScore();
        for (Map.Entry<String, Sportsman> entry : sortedMap.entrySet()) {
            Sportsman sportsman = entry.getValue();
            int currentScore = sportsman.getTotalScore();
            if (currentScore == prevScore) {
                sportsman.setPlace(currentPlace);
            } else {
                currentPlace++;
                sportsman.setPlace(currentPlace);
            }
            prevScore = currentScore;
        }

        for (Sportsman sportsman : sortedMap.values()) {
            System.out.println(sportsman);
        }
    }
    public static Map<String, Sportsman> readDataFromFile(String filename) throws IOException {
        Map<String, Sportsman> sportsmenMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int n = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());

            for (int i = 0; i < n; i++) {
                String input = reader.readLine();
                String[] parts = input.split(" ");

                String surname = parts[0];
                String name = parts[1];
                String fullName = surname + " " + name;

                int totalScore = 0;
                for (int j = 2; j < 2 + m; j++) {
                    totalScore += Integer.parseInt(parts[j]);
                }


                sportsmenMap.put(fullName, new Sportsman(fullName, totalScore));
            }
        }
        return sportsmenMap;
    }
}
