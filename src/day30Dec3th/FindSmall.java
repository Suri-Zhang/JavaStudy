package day30Dec3th;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rex Joush
 * @time 2022.12.03
 */
public class FindSmall {

    ArrayList<String> list = new ArrayList<>();



    // "aaa" "vbcas" "asdsa" "igfjkl"
    public static String getMin(List<String> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        String min = getMin(list.subList(1, list.size()));
        if (list.get(0).compareTo(min) < 0) {
            return list.get(0);
        } else {
            return min;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();

        list1.add("aa");
        list1.add("cc");
        list1.add("bb");
        list1.add("dd");
        list1.add("ff");
        list1.add("ee");
        System.out.println(getMin(list1));

    }

}
