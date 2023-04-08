package day38Mar17th;

import java.util.Scanner;

/**
 * @author Rex Joush
 * @time 2023.03.19
 */
public class Test {
    public static void main(String[] args) {

        Equation equation = new Equation();
        Scanner input = new Scanner(System.in);
        equation.init();
        while (true) {
            System.out.println("Please enter an equation(or -1 to exit or 1 to change to binary): ");
            String str = input.nextLine();
            if (str.equals("-1")) {
                System.out.println("Good bye");
                break;
            }
            if (str.equals("1")) {
                System.out.println("Please enter an number: ");
                int  num = Integer.parseInt(input.nextLine());
                System.out.println(equation.KChange(num));
            }
            else if (equation.check(str)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
