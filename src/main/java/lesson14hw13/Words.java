package lesson14hw13;

import java.util.HashMap;
import java.util.Map;

public class Words {

    public static Map<String, Integer> countWords(String text) {

        Map<String, Integer> wordCountMap = new HashMap<>();

        text = text.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();

        String[] words = text.split("\\s+");

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        return wordCountMap;
    }
}
