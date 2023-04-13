package day10Mar21th;

/**
 * @author Rex Joush
 * @time 2022.06.06
 */
public class StringTest {


    class Person {
        String name;
        int age;

        public Person(String name, int age, int height) {
            this.name = name;
            this.age = age;
        }
    }


    public void test3() {
        Person p1 = new Person("tom", 20, 179);
        Person p2 = new Person("aa", 24, 182);
        Person p3 = new Person("ac", 18, 170);
        Person p4 = new Person("bc", 20, 165);
        Person p5 = new Person("bd", 21, 179);
        Person p6 = new Person("joush", 20, 170);

        // p2 p5 p4 p6 p1 p3

    }


    public static void main(String[] args) {
        System.out.println(" \" \" ");
    }



    public void test3(int a, int b) {
        String s1 =  "asldkjasd";
        String s18 = "asladfgdkjasd";

        if (s1.compareTo(s18) == 0) {
            System.out.println("s1 == s18");
        }

        String s14 = "hdfg";
        String s12 = "afdg";
        String s6 = "adfg";
        String s4 = "asadfgldkjasd";
        String s3 = "adsgsldkjasd";

        int[] nums = new int[]{
                3
                ,10
                ,324
                ,435
                ,62
                ,145};
    }

}
