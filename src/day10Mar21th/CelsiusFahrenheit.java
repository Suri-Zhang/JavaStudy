package day10Mar21th;

/**
 * @author Rex Joush
 * @time 2022.05.27
 */
public class CelsiusFahrenheit {

    public static void main(String[] args) {
        double test1 = 86;
        double c1 = F2C(test1);
        System.out.println(c1); // 30
        System.out.println(C2F(c1)); // 86

        double test2 = 50;
        double c2 = F2C(test2);
        System.out.println(c2); // 10
        System.out.println(C2F(c2)); // 50

        double test3 = 50.1;
        double c3 = F2C(test3);
        System.out.printf("%.15f\n", c3); // 10.055555...
        System.out.printf("%.15f\n", C2F(c3)); // 50.1
    }

    public static double F2C(double f) {
        return (f - 32f) * 5f / 9f;
    }

    public static double C2F(double c) {
        return (c * 9f / 5f) + 32f;
    }

}
