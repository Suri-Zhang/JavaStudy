import day24Sep23th.Thing;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Rex Joush
 * @time 2022.06.17
 */
public class BinSearch {


    public List<String> generateParenthesisMe(int n) {
        List<String> list = new ArrayList<>();
        backTracking(n, list, 0, 0, "");
        return list;
    }


    public void backTracking(int n, List<String> list, int left, int right, String str) {
        if (left < right) {
//            str.deleteCharAt(str.length() - 1);
            return;
        }

        if (left == right && left == n) {
            list.add(str);
//            str.deleteCharAt(str.length() - 1);
        }

        if (left < n) {
//            str.append('(');
            backTracking(n, list, left + 1, right, str + "(");
        }

        if (right < left) {
//            str.append(')');
            backTracking(n, list, left, right + 1, str + ")");
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\joush\\Desktop\\导师遴选教师信息new.sql";
//        String path = "C:\\Users\\joush\\Desktop\\teacher_info.sql";
        FileReader fileReader = new FileReader(path);
//        byte[] bytes = new byte[70];
        char[] chars = new char[1024];
        fileReader.read(chars);
        System.out.println(chars);

//        Scanner sc = new Scanner(new File(path));

//        String id = "410329199708179592";
//        System.out.println(id.substring(6, 14));
//        Date date = new Date("1997-08-17");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(sdf.format(date));
//        Date date = new Date("1997/1/1");
//        System.out.println(sdf.format(date));

        // FileWriter fileWriter = new FileWriter(path);
//        fileWriter.
//        FileOutputStream fileOutputStream = new FileOutputStream(path);
//        fileOutputStream.write(chars, 0, 70);
        //fileWriter.write(chars, 0, 70);
//        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path));
//        outputStream.write(bytes, 0, 70);
//        outputStream.flush();
//        FileInputStream inputStream = null;
//        Scanner sc = null;
//        int i = 0;
//        try {
//            inputStream = new FileInputStream(path);
//            sc = new Scanner(inputStream);
//            while (i < 20) {
//                String line = sc.nextLine();
//                System.out.println(line);
//                i++;
//            }
//            // note that Scanner suppresses exceptions
//            if (sc.ioException() != null) {
//                throw sc.ioException();
//            }
//        } finally {
//            if (inputStream != null) {
//                inputStream.close();
//            }
//            if (sc != null) {
//                sc.close();
//            }
//        }

    }

    String str = new String("hello");
    char[] ch = new char[]{'a', 'b', 'c'};

    public void fun(String str, char[] ch) {
        str = "world";
        ch[0] = 'd';
    }

    public static String[] parseInput(String text) {
        // find first number index
        int firstNumber = findFirstNumber(text);
        // get name string
        String name = text.substring(0, firstNumber);
        // get data string
        String data = text.substring(firstNumber);

        // parse name
        int lastSpace = name.lastIndexOf(" ");
        String firstname = name.substring(0, lastSpace - 1);
        String lastname = name.substring(lastSpace + 1);

        // parse data
        String[] dataArray = data.trim().split(" ");

        return new String[]{firstname, lastname, dataArray[0], dataArray[1], dataArray[2], dataArray[3]};
    }

    public static int findFirstNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return i - 1;
            }
        }
        return 0;
    }

    public static void noRepeat() {

        // 生成的随机数结果
        int[] result = new int[10];
        int index = 0;

        while (index < 10) {
            // 生成一个随机数
            int xx = (int) (Math.random() * 50);

            // 判断是否在result 中
//            if (xx在) {
//                // 继续生成
//            } else {
//                // 放入结果数组中
//                result[index] = xx;
//                index++;
//            }
        }
    }


    public String getRes(String str) {
        if (str == null || "".equals(str)) {
            return "Empty";
        }
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 1) {
                s += str.charAt(i);
            }
        }
        return s;
    }

    public static int multiplyDigits(int n) {
        if (n < 100 || n > 999) {
            return 0;
        }
        int res = 1;
        while (n != 0) {
            res *= n % 10;
            n /= 10;
        }
        return res;
    }


}
