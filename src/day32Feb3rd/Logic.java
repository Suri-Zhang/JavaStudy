package day32Feb3rd;

/**
 * @author Rex Joush
 * @time 2023.02.04
 */
public class Logic {

    public static void main(String[] args) {
        boolean x = true;
        boolean y = false;
        System.out.println(executeS(x, y));
        System.out.println(executeC(x, y));
    }

    // 与，或，非，异或，同或，与非，或非

    public static boolean executeS(boolean x, boolean y) {
        return x && y || x != y;
    }

    public static boolean executeC(boolean x, boolean y) {
        return x != y;
    }

}
