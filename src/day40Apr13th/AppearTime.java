package day40Apr13th;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AppearTime {

    static class Word {
        private String key;
        private int value;
    }

    public static void sorted(String fileName) throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileName));
        TreeMap<String, Integer> map = new TreeMap<>();
        // TreeMap<Word, Word> num = new TreeMap<>();

        while (in.hasNext()) {
            in.useDelimiter("[^a-zA-Z]+");
            String theWord = in.next().toLowerCase();
            Integer times = map.getOrDefault(theWord, 0) + 1;
            map.put(theWord,times);
            // num.put(times, theWord);
        }
        int size = map.size();

        Word[] words = new Word[size];
        int index = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Word word = new Word();
            word.key = entry.getKey();
            word.value = entry.getValue();
            words[index++] = word;
        }
        Arrays.sort(words, new Comparator<Word>() {
            @Override
            public int compare(Word w1, Word w2) {
                return w1.value - w2.value;
            }
        });
//        Arrays.sort(words, (w1, w2) -> {
//            return w1.value - w2.value;
//        });
        // Arrays.sort(words, Comparator.comparingInt(w -> w.value));
        for (int i = words.length - 10; i < words.length; i++) {
            System.out.println(words[i].key + ", count= " + words[i].value);
        }
        // Set, List, Map, Tree(key)
    }

    public static void main(String[] args) throws FileNotFoundException {
        sorted("/Users/azur/Documents/JavaStudy/src/day40Apr13th/warAndPeace.txt");
    }

}
