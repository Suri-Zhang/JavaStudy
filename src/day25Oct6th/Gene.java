package day25Oct6th;

public abstract class Gene implements Cloneable {

    public abstract Gene clone();
    public abstract boolean isSimilar(Gene g);
}
