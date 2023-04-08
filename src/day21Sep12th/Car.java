package day21Sep12th;

/**
 * @author Rex Joush
 * @time 2022.09.12
 */
public class Car {

    private String make;
    private int mile;

    public Car(String make) {
        this.make = make;
    }

    public Car(String make, int mile) {
        this.make = make;
        this.mile = mile;
    }

    public String getMake() {
        return make;
    }

    public int getMile() {
        return mile;
    }

    public void drive() {
        System.out.println("Drive...");
    }
}
