import java.io.*;
import java.util.*;
public class SetSymbolFinder {
    public static String readTextFromFile(String filename) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append(" ");
            }
        }
        return text.toString();
    }
    public static Set<Character> findUniqueCharsInWords(String text) {
        // Преобразуем текст в массив слов
        String[] words = text.split("\\s+");

        // Карта для подсчета количества появления символов в каждом слове
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        // Множество для хранения уникальных символов
        Set<Character> uniqueChars = new HashSet<>();

        // Пробегаем по всем словам и подсчитываем символы
        for (String word : words) {
            Set<Character> seenCharsInWord = new HashSet<>(); // Чтобы не учитывать повторяющиеся символы в одном слове
            for (char c : word.toCharArray()) {
                if (!seenCharsInWord.contains(c)) {
                    // Если символ в первый раз в текущем слове
                    seenCharsInWord.add(c);
                    charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
                }
            }
        }

        // Теперь выбираем те символы, которые встречаются ровно один раз
        for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueChars.add(entry.getKey());
            }
        }

        return uniqueChars;
    }
}
