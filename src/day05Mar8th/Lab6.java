package day05Mar8th;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab6 {
    public static  void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        boolean scucces = true;
        String fileName = "";
        int count = 0;

        while (scucces) {
            System.out.println("Enter you file name : ");
            fileName = kb.next();
            count++;
            if ("sumA.txt".equals(fileName)
                    || "sumB.txt".equals(fileName) || "sumC.txt".equals(fileName)) {
                scucces = false;
            } else if (count <= 1) {
                System.out.println("badname.");
            } else {
                System.out.println("still vaild name.");
            }

        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double average = 0;
        int total = 0;
        String c = "";
        int sums = 0;
        int nums = 0;


        try {
            Scanner file = new Scanner(new File(fileName));

            while (file.hasNextInt())  {
                nums = file.nextInt();

                try {
                    c = String.valueOf(nums);

                } catch (Exception e) {
                    System.out.println("sikping" + c);
                    continue;
                }

                if (max < nums) {
                    max = nums;
                } if (min > nums) {
                    min = nums;
                }
                count++;
                sums += nums;
            }
            average = (double)nums / count;

            file.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("no input value.");
        }
        System.out.println();
        System.out.println("Total  : " + sums);
        System.out.println("Min    : " + min);
        System.out.println("Max    : " + max);
        System.out.println("Average: " + average);
    }
}