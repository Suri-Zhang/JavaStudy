package day25Oct6th;

/**
 * @author Rex Joush
 * @time 2022.10.06
 */
public abstract class Parent {

    protected int getValue () {
        return -1;
    }

}

class Child extends Parent {
    public int getValue () {
        return -1;
    }
}
