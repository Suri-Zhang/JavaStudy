package day30Dec3th;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rex Joush
 * @time 2022.12.03
 */
public class Main {
    private List<Shape> shapes;
    public void add(Shape shape) {
        shapes.add(shape);
    }
    public Main() {
        shapes = new ArrayList<>();
    }
    public double getAllArea() {
        double res = 0.0;
        for (Shape shape : shapes) {
            res += shape.getArea();
        }
        return res;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Square square1 = new Square(3);
        Circle circle = new Circle(1);
        Square square2 = new Square(2);
        main.shapes.add(square1);
        main.shapes.add(circle);
        main.shapes.add(square2);
        System.out.println(main.getAllArea());
    }
}
