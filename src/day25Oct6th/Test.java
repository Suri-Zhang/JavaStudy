package day25Oct6th;

/**
 * @author Rex Joush
 * @time 2022.10.06
 */
public class Test implements Cloneable {
    private int age;
    protected int n;

    public Test(){}
    public Test(int age){
        this.age = age;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Pet pet = new Pet("pet1");
        Pet pet2 = pet.clone();  // clone
        Pet pet4 = pet;          // shadow copy
        Pet pet3 = new Pet(pet); // copy constructor
        System.out.println(pet2.getName());
        Test t = new Test();
        Two two = new Two(1,"1",2);
    }

    public void test1(Dog dog) throws CloneNotSupportedException {

    }

    public void test2(Cat cat) {
        System.out.println(cat.getName());
    }

    public void test3(Pet pet) {
        System.out.println(pet.getName());
    }

}
