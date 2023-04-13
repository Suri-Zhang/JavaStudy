package day07Mar11th;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Rex Joush
 * @time 2022.03.11
 */
public class Demo01 {

    public static void main(String[] args) {

        String a = "reccer";


        Scanner sc = new Scanner(System.in);

        //
        String filename = sc.next();
        int total = 0;
        try {
            //
            Scanner scanner = new Scanner(new File(filename));
            // use string read, read string
            while (scanner.hasNext()) {
                try {
                    // receive int
                    int i = scanner.nextInt();
                    total += i;
                } catch (Exception e) {
                    // if string, skip to next
                    scanner.next();
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("badfile" +
                    "INVALID FILE PROVIDED  GOODBYE!");
        }
        System.out.println(total);

    }

}
