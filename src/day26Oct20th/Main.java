package day26Oct20th;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Test t1 = new Test();
        t1.a = 10;
        ArrayList<Test> list = new ArrayList<>();

        list.add(t1);
        System.out.println(list);
        Test test = list.get(0);
        test.a = 20;
        System.out.println(list);
    }


}
class Test {
    int a;

    @Override
    public String toString() {
        return "Test{" +
                "a=" + a +
                '}';
    }
}