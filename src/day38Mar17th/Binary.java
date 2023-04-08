package day38Mar17th;

/**
 * @author Rex Joush
 * @time 2023.03.19
 */
public class Binary {

    public static void main(String[] args) {
        // 10 -> 2
        int n = 31;
        Binary binary = new Binary();
        System.out.println(binary.KChange(n, 16));
    }

    public String KChange(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int temp = n % k;
            sb.append(temp);
            n /= k;
        }
        return sb.reverse().toString();
    }

}
