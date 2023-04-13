import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

import static java.lang.Integer.MIN_VALUE;

public class AppearTime {

    public static TreeMap<Integer, String> sorted(String fileName) throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileName));
        TreeMap<String, Integer> map = new TreeMap<>();
        TreeMap<Integer, String> num = new TreeMap<>();

        while (in.hasNext()) {
            in.useDelimiter("[^a-zA-Z]+");
            String theWord = in.next().toLowerCase();
            Integer times = map.getOrDefault(theWord, 0) + 1;
            map.put(theWord,times);
            num.put(times, theWord);
        }
        return num;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int i = 0;
        TreeMap<Integer, String> sorted = sorted("warAndPeace.txt");
        for (int num = sorted.lastKey(); num >= 0; num-- ) {
            System.out.println("Key: " + num + ", Value: " + sorted.get(num));
            i++;
            if (i == 10){
                break;
            }
        }
    }

}
