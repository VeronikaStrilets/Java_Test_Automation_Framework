package lesson14hw13;

import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        String text = "Arise, fair sun, and kill the envious moon.";

        Map<String, Integer> wordCountMap = Words.countWords(text);

        Map<String, Integer> sortedByLengthMap = new TreeMap<>(new Sorting());
        sortedByLengthMap.putAll(wordCountMap);

        System.out.println("Words and their occurrence count (sorted by word length):");
        for (Map.Entry<String, Integer> entry : sortedByLengthMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
