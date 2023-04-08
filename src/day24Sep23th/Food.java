package day24Sep23th;

public abstract class Food extends Thing {
    protected float price;
    protected float weight;
    
    /**
     * This is using for getting data.
     * @param price This is price.
     * @param weight This is weight.
     */
    public Food(float price, float weight) {
        this.price = price;
        this.weight = weight;
    }
    
    /**
     * This is coming from parent class.
     */
    public abstract float getPrice();
    
    /**
     * This is coming from parent class.
     * @return Return nothing.
     */
    public abstract float getWeight();
    
    /**
     * This is ensuring if the food is same or not.
     */
    public boolean equals(Object o) {
        if (o instanceof Food) {
            Food food = (Food)o;
            if (getPrice() == food.getPrice() 
                    && getWeight() == food.getWeight()) {
                return true;
            }      
        } 
        return false;
    }
    

}
