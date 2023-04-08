package day24Sep23th;

public class Cat extends Pet {
    
    /**
     * Get data.
     * @param kind This is kind.
     * @param price This is price.
     * @param foodPerDay This is food.
     */
    public Cat(String kind, float price, float foodPerDay) {
        super(kind, price, foodPerDay);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Get kind.
     */
    @Override
    public String getKind() {
        // TODO Auto-generated method stub
        return "Cat: " + kind;
    }

    /**
     * Get price.
     */
    @Override
    public float getPrice() {
        // TODO Auto-generated method stub
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
     * Ensuring is aquatic.
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
        return String.format("%s\t%s\t%.2f\t%.2f", "Cat", 
                kind, price, foodPerDay);
        
    }
    

}
