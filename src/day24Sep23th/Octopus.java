package day24Sep23th;

public class Octopus extends Pet {

    /**
     * This is using for getting data.
     * @param kind The kind of octopus.
     * @param price The price of octopus.
     * @param foodPerDay The food of octopus.
     */
    public Octopus(String kind, float price, float foodPerDay) {
        super(kind, price, foodPerDay);
        // TODO Auto-generated constructor stub
    }

    /**
     * This is using for getting kind.
     */
    @Override
    public String getKind() {
        // TODO Auto-generated method stub
        return "Octopus: " + kind;
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
     * This is using for getting food.
     */
    @Override
    public float getFoodPerDay() {
        // TODO Auto-generated method stub
        return this.foodPerDay;
    }

    /**
     * This is using for ensuring if it is aquatic.
     */
    @Override
    public boolean isAquatic() {
        // TODO Auto-generated method stub
        return true;
    }
    
    /**
     * This is to string methods.
     */
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f", "Octopus", 
                 kind, price, foodPerDay);
    }
}
