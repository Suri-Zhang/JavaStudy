package day23Sep21th;

/**
 * @author Rex Joush
 * @time 2022.09.21
 */
public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("MainCat");
        Cat cat1 = new Cat("MainCat");
        System.out.println(cat.equals(cat1));
    }

}
