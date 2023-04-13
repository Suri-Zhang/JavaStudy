package day38Mar17th;

import java.util.Stack;

public class ConvertBin {

    GenericStack<String> stringGenericStack = new GenericStack<>();



    public void pushInside(int num) {
        Stack<Integer> stack = new Stack<>();
        int val = 0;
        /*
            15     111111111111
            7
            3
            1
            0
        */

        while (num != 0) {
           stack.push(num % 2);
           num /= 2;
        }
        stack.push(0);

        }

    }
