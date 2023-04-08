package day01Mar5th;

/**
 * @author Rex Joush
 * @time 2022.03.05
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lab6 {

    public static void main(String[] args) {

        boolean success = true;

        Scanner kb = new Scanner(System.in);
        String c = "";


        // 1.input filename
        // 1.while
        int v = 0;
        while (success) {
            System.out.print("Please enter the name of the file: ");
            c = kb.next();
            v++;
            if ("sumA.txt".equals(c) || "numsB.txt".equals(c) || "numsC.txt".equals(c)) {
                success = false;
            } else {
                if (v <= 1) {
                    System.out.println("badname (The system cannot"
                            + "find the file specified)");
                } else {
                    System.out.println("stillbad (The system cannot"
                            + "find the file specified)");
                }
            }
        }


        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        double average = 0;
        int count = 0;

        try {

            Scanner file = new Scanner(new File(c));

            while (file.hasNext()) {
                int num = 0;
                String s = "";
                try {
                    s = file.next();
                    num = Integer.parseInt(s);
                    success = false;
                } catch (Exception e) {
                    System.out.println("Skipping over invalid input: " + s);
                    success = true;
                }

                if (!success) {
                    // update max
                    if (num > max) {
                        max = num;
                    }
                    // update min
                    if (num < min) {
                        min = num;
                    }
                    // sum
                    sum += num;
                    count++;
                }
            }
            // average
            average = (double) sum / count;
            file.close();

        } catch (FileNotFoundException e) {
            System.out.println("badname (The system cannot"
                    + "find the file specified");
        }
        System.out.println();
        System.out.println("Total  : " + sum);
        System.out.println("Min    : " + min);
        System.out.println("Max    : " + max);
        System.out.println("Average: " + average);

        kb.close();
    }
}