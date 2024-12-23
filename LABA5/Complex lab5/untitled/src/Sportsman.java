import java.io.*;
import java.util.*;
public class Sportsman {
    private String fullName;  // Полное имя (Фамилия + Имя)
    private int totalScore;   // Сумма баллов
    private int place;        // Место

    // Конструктор
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
        // Для сортировки по значениям создадим дополнительную карту
        Map<String, Sportsman> sortedMap = new LinkedHashMap<>();

        // Сортируем Map по сумме баллов с помощью Stream API
        sportsmenMap.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getTotalScore(), e1.getValue().getTotalScore()))
                .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));

        // Присваиваем места спортсменам с учетом одинаковых баллов
        int currentPlace = 1;
        Iterator<Map.Entry<String, Sportsman>> iterator = sortedMap.entrySet().iterator();
        if (iterator.hasNext()) {
            Map.Entry<String, Sportsman> firstEntry = iterator.next();
            Sportsman firstSportsman = firstEntry.getValue();
            firstSportsman.setPlace(currentPlace);
        }

        // Теперь присваиваем места для остальных
        int prevScore = sortedMap.entrySet().iterator().next().getValue().getTotalScore();
        for (Map.Entry<String, Sportsman> entry : sortedMap.entrySet()) {
            Sportsman sportsman = entry.getValue();
            int currentScore = sportsman.getTotalScore();
            if (currentScore == prevScore) {
                sportsman.setPlace(currentPlace); // Место остается тем же
            } else {
                currentPlace++; // Новый спортсмен получает следующее место
                sportsman.setPlace(currentPlace);
            }
            prevScore = currentScore;
        }

        // Выводим таблицу результатов
        for (Sportsman sportsman : sortedMap.values()) {
            System.out.println(sportsman);
        }
    }
    public static Map<String, Sportsman> readDataFromFile(String filename) throws IOException {
        Map<String, Sportsman> sportsmenMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Считываем количество спортсменов N и количество видов спорта M
            int n = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());

            // Считываем информацию о каждом спортсмене
            for (int i = 0; i < n; i++) {
                String input = reader.readLine();  // Считываем строку спортсмена
                String[] parts = input.split(" ");  // Разбиваем строку на фамилию, имя и баллы

                String surname = parts[0];  // Фамилия спортсмена
                String name = parts[1];     // Имя спортсмена
                String fullName = surname + " " + name;  // Полное имя (ключ)

                // Суммируем баллы по каждому виду спорта
                int totalScore = 0;
                for (int j = 2; j < 2 + m; j++) {
                    totalScore += Integer.parseInt(parts[j]);  // Считаем сумму баллов
                }

                // Добавляем спортсмена в Map (Фамилия + Имя -> Объект Sportsman)
                sportsmenMap.put(fullName, new Sportsman(fullName, totalScore));
            }
        }
        return sportsmenMap;
    }
}
