package lesson14hw13;

import java.util.Comparator;

public class Sorting implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        int lengthComparison = Integer.compare(s1.length(), s2.length());
        if (lengthComparison != 0) {
            return lengthComparison;
        }
        return s1.compareTo(s2);
    }
}
