package day10Mar21th;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Rex Joush
 * @time 2022.05.29
 */
public class SumAva {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scanner.next();

        System.out.print("Enter your last name: ");
        String lastName = scanner.next();

        System.out.print("Enter your three test scores: ");
        double score1 = scanner.nextDouble();
        double score2 = scanner.nextDouble();
        double score3 = scanner.nextDouble();

        System.out.println(firstName.substring(0,1).toUpperCase() + "." +
                lastName.substring(0, 1).toUpperCase() + "'s average is " +
                getAverage(score1, score2, score3));
        System.out.println(firstName.substring(0,1).toUpperCase() + "." +
                lastName.substring(0, 1).toUpperCase() + "'s maximum is " +
                getMax(score1, score2, score3));

    }

    private static double getMax(double score1, double score2, double score3) {
        return Math.max(Math.max(score1, score2), score3);
    }

    private static double getAverage(double score1, double score2, double score3) {
        return (score1 + score2 + score3) / 3;
    }

}
