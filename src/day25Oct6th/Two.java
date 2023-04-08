package day25Oct6th;

/**
 * @author Rex Joush
 * @time 2022.10.06
 */
public class Two extends One {


    private float f;

    public Two(int x1, String y1, float f1) {
        super(x1, y1);
        this.f = f1;
    }

    public String toString() {
        return super.toString() + " " + f;
    }

}
