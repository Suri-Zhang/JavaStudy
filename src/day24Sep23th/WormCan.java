package day24Sep23th;

public class WormCan extends Food {

    /**
     * This is using for asking variables from parent.
     * @param price This is input parameter.
     * @param weight This is input parameter.
     */
    public WormCan(float price, float weight) {
        super(price, weight);
    }
    
    /**
     * This is using for getting price.
     */
    @Override
    public float getPrice() {
        return this.price;
    }

    /**
     * This is using for get weight.
     */
    @Override
    public float getWeight() {
        return this.weight;
    }

    /**
     * This is using for getting kind.
     */
    @Override
    public String getKind() {
        return "WormCan";
    }

    /**
     * This is using for ensuring if it is aquatic or not.
     */
    @Override
    public boolean isAquatic() {
        return true;
    }
    
    /**
     * This is to String methods.
     */
    public String toString() {
        return String.format("%s\t%.2f\t%.2f", "WormCan", price, weight); 
    }

}
