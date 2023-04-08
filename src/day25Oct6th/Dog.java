package day25Oct6th;

/**
 * @author Rex Joush
 * @time 2022.10.06
 */
public class Dog extends Pet {
    private float height;

    public Dog(Cat cat) {
        super(cat);
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
