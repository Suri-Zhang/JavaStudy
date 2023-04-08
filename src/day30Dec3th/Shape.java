package day30Dec3th;

/**
 * @author Rex Joush
 * @time 2022.12.03
 */
public abstract class Shape {

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getArea();
}
