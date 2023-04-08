package day28Nov12th;

/**
 * @author Rex Joush
 * @time 2022.11.12
 */
public class Divide {


    /*
        10!
        10 * 9!
             9 * 8!
                 8 * 7!
        n! = n * (n-1)!
     */

    public static void main(String[] args) {
        Divide divide = new Divide();
        System.out.println(divide.reverse("reverse"));
    }

    //
    public String reverse(String str) {
        if (str.length() == 1) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }


    // f(n) = f(n-1) + f(n-2);

    public int func2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return func2(n - 1) + func2(n - 2);
    }

    // int func(int n)   求 n 的阶乘

    public int func(int n) {
        // 递归的结束条件
        if (n == 1) {
            return 1;
        }
        // 每一项的操作

        // 递归函数
        return n * func(n - 1);
    }

}
