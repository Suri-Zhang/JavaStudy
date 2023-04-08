package day25Oct6th;

/**
 * @author Rex Joush
 * @time 2022.10.06
 */
public class Cat extends Pet {
    private float weight;

    public Cat(Cat cat) {
        super(cat);
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public void show(int a) {
        System.out.println("Cat: " + a);
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

}
