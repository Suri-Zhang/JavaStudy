package day25Oct6th;

/**
 * @author Rex Joush
 * @time 2022.10.06
 */
public class Pet {

    private String name;

    public Pet(Pet pet) {
        this.name = pet.name;
    }

    public Pet(String name) {
        this.name = name;
    }
    public Pet() {}

    public void showName() {
        System.out.println(name);
    }

    public void show(int a) {
        System.out.println("Pet: " + a);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Pet clone() throws CloneNotSupportedException {
        return this;
    }
}
