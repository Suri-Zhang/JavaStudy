package day23Sep21th;

/**
 * @author Rex Joush
 * @time 2022.09.21
 */
public abstract class Pet {
    protected String kind;

    public Pet(String kind) {
        this.kind = kind;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Pet) {
            Pet pet = (Pet) o;
            return kind.equals(pet.kind);
        }
        return false;
    }
}
