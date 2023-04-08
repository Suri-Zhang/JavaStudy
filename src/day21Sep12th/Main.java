package day21Sep12th;

import java.util.Scanner;

/**
 * @author Rex Joush
 * @time 2022.09.12
 */
public class Main {
    public Car car1 = new Car("name111", 10000);

    public static void main(String[] args) {
        String name = "name111";
        int mile = 10000;

        Car car2 = new Car("name222", 20000);
        Car car3 = new Car("name333", 30000);

        int mile2 = car2.getMile();

        int mile3 = car3.getMile();

    }

}
