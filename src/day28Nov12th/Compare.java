package day28Nov12th;

import day25Oct6th.Person;

/**
 * @author Rex Joush
 * @time 2022.11.12
 */


public class Compare {


    public static void main(String[] args) {
        int a = 0;
        int b = 10;
        Person person1 = new Person(11, 170);
        Person person2 = new Person(11, 171);

        System.out.println(person1.compareTo(person2));

    }

}
