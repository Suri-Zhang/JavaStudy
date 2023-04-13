package day38Mar17th;

import java.util.HashSet;
import java.util.Set;

public class Equation {
    /*
             (数字 符号 数字 符号 数字)
             (1 * 2 * 3)
                 1
            ((2 + 16 * 4) + 33 - 2)
            ((2 + 16 * 4 +) 33 - 2)
            1

              4
            | *   |    |     |
            | 1   |    |     |
            | +   |    |     |
            | 2   |    |     |
            | (   |    |     |
            | (   |    |  26 |
            ------      ------
     */



    public void init() {
        set = new HashSet<>();
        set.add(')');
        set.add('(');
        set.add('*');
        set.add('/');
        set.add('+');
        set.add('-');
        operator = new GenericStack<>();
    }
    public boolean check(String str) {
        char[] chars = str.toCharArray();
        // 1 - 22
        StringBuilder sb = new StringBuilder();

        for (char ch : chars) {
            // 是符号
            if (set.contains(ch)) {
                // 将之前的数字添加至栈中
                if (sb.length() > 0) {
                    operator.push(sb.toString());
                    sb = new StringBuilder();
                }
                // 右括号进行操作
                if (ch == ')') {
                    if (!op()) {
                        return false;
                    }
                } else {
                    // 其余符号，直接推入栈
                    operator.push(String.valueOf(ch));
                }
            } else if (Character.isDigit(ch)) {
                // 是数字
                sb.append(ch);
            } else {
                if (sb.length() > 0) {
                    operator.push(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }

        // 最后一个数字再判断一次
        if (sb.length() > 0) {
            operator.push(sb.toString());
        }
        return opLast();
    }

    public boolean opLast() {
        int index = 1;
        while (!operator.isEmpty()) {
            String pop = operator.pop();
            // 找到括号就出问题，直接返回 false
            if ("(".equals(pop) || ")".equals(pop)) {
                return false;
            }
            if (!checkExp(pop, index++)) {
                return false;
            }
        }
        return true;
    }

    public boolean op() {
        // 将栈中所有到左括号之前的序列弹出来，进行判断
        int index = 1;
        boolean flag = false;
        // )
        while (true) {
            if (operator.isEmpty()) {
                break;
            }

            // 找到左括号就停止
            if ("(".equals(operator.peek())) {
                operator.pop();
                if (index > 1) {
                    operator.push("1");
                }
                flag = true;
                break;
            }
            if (!checkExp(operator.pop(), index++)) {
                return false;
            }
        }
        // 没遇见左括号，直接返回 false
        if (!flag) {
            return false;
        }
        return true;
    }

    // 检测是否正确
    public boolean checkExp(String pop, int i) {
        // 奇数位置是数字
        if (i % 2 == 1) {
            try {
                Integer.parseInt(pop);
            } catch (Exception e) {
                return false;
            }
        } else {
            // 偶数位置是符号
            return set.contains(pop.charAt(0));
        }
        return true;
    }

    private Set<Character> set;
    private GenericStack<String> operator;

    public String KChange(int n) {
        GenericStack<String> stack = new GenericStack<>();
        while (n != 0) {
            int temp = n % 2;
            stack.push(String.valueOf(temp));
            n /= 2;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            sb.append(pop);
        }
        return sb.toString();
    }
}
