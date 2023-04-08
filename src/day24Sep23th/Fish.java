package day24Sep23th;

public class Fish extends Pet {
    
    /**
     * This get data.
     * @param kind This is kind.
     * @param price This is price.
     * @param foodPerDay This is food.
     */
    public Fish(String kind, float price, float foodPerDay) {
        super(kind, price, foodPerDay);
        // TODO Auto-generated constructor stub
    }

    /**
     * This is using for getting kind.
     */
    @Override
    public String getKind() {
        // TODO Auto-generated method stub
        return "Fish: " + kind;
    }

    /**
     * This is using for getting price.
     */
    @Override
    public float getPrice() {
        // TODO Auto-generated method stub
        return price;
    }

    /**
     * This is get food.
     */
    @Override
    public float getFoodPerDay() {
        // TODO Auto-generated method stub
        return this.foodPerDay;
    }


    /**
     * This ensure is ensuring.
     */
    @Override
    public boolean isAquatic() {
        // TODO Auto-generated method stub
        return true;
    }
    
    /**
     * String methods.
     */
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f", "Fish", 
                kind, price, foodPerDay);
        
    }
}
