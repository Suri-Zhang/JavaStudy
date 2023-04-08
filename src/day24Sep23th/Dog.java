package day24Sep23th;

public class Dog extends Pet {
    
    /**
     * Getting data.
     * @param kind This is kind.
     * @param price This is price.
     * @param foodPerDay This is food.
     */
    public Dog(String kind, float price, float foodPerDay) {
        super(kind, price, foodPerDay);
    }
    
    /**
     * This gets kind.
     */
    @Override
    public String getKind() {
        return "Dog: " + kind;
    }

    /**
     * Getting price.
     */
    @Override
    public float getPrice() {
        return price;
    }

    /**
     * Get food.
     */
    @Override
    public float getFoodPerDay() {
        // TODO Auto-generated method stub
        return this.foodPerDay;
    }

    /**
     * ensure it is aquatic.
     */
    @Override
    public boolean isAquatic() {
        // TODO Auto-generated method stub
        return false;
    }
    
    /**
     * String methods.
     */
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f", "Dog", 
                kind, price, foodPerDay);
        
    }


}
