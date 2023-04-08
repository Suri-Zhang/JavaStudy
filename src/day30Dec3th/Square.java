package day30Dec3th;

/**
 * @author Rex Joush
 * @time 2022.12.03
 */
public class Square extends Shape {
    private int side;
    public Square() {
    }
    public Square(int side) {
        this.side = side;
    }
    @Override
    public double getArea() {
        return side * side;
    }
    public int getSide() {
        return side;
    }
    public void setSide(int side) {
        this.side = side;
    }
    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return side == square.side;
    }

    @Override
    protected Square clone() throws CloneNotSupportedException {
        return (Square) super.clone();
    }
}
