package day10Mar21th;

/**
 * @author Rex Joush
 * @time 2022.03.21
 */
public class FunctionTest {

    public static void main(String[] args) {

        System.out.println(sum(1, 10));
        System.out.println(sum(11, 20));
        System.out.println(sum(31, 40));
        System.out.println(sum(41, 50));

    }

    public static int sum(int a, int b) {
        int sum = 0;

        for (int i = a; i <= b; i++) {
            sum += i;
        }
        return sum;
    }

    public int nextDiv8(int num){

        if (num % 8 == 0) {
            return num; // 8,16,24
        } else {
            return (int) Math.ceil(num * 1.0 / 8) * 8;
        }
    }





    // method
    // public 共有，所有地方可见
    // private 私有，本类可见
    // protected 受保护的，本分类可见

    //
    // public, private, protected     static, final, synchronized     int, String, List   name2
    // ()

    public static int myMaxFunc(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}
