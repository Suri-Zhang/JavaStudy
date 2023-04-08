package day24Sep23th;

public class ChowBag extends Food {
    
    /**
     * Get data.
     * @param price This is price.
     * @param weight This is weight.
     */
    public ChowBag(float price, float weight) {
        super(price, weight);
        // TODO Auto-generated constructor stub
    }

    /**
     * Get weight.
     */
    @Override
    public float getWeight() {
        // TODO Auto-generated method stub
        return weight;
    }

    /**
     * Get Kind.
     */
    @Override
    public String getKind() {
        // TODO Auto-generated method stub
        return "ChowBag";
    }

    /**
     * This ensure is ensuring.
     */
    @Override
    public boolean isAquatic() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * get price.
     */
    @Override
    public float getPrice() {
        // TODO Auto-generated method stub
        return this.price;
    }
    
    /**
     * String methods.
     */
    public String toString() {
        return String.format("%s\t%.2f\t%.2f", "ChowBag", 
                price, weight); 
    }

}
