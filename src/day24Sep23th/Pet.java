package day24Sep23th;

public abstract class Pet extends Thing {
    
    protected String kind;
    protected float price;
    protected float foodPerDay;

    /**
     * This is using for storing needed variables.
     * @param kind The kind of pet.
     * @param price The price of pet.
     * @param foodPerDay The food for pet.
     */
    public Pet(String kind, float price, float foodPerDay) {
        this.kind = kind;
        this.price = price;
        this.foodPerDay = foodPerDay;
    }
    
    /**
     * This is using for get price.
     */
    public abstract float getPrice();
    
    /**
     * This is using for getting food.
     * @return return nothing.
     */
    public abstract float getFoodPerDay();
    
    /**
     * This is using to find if the kind is same.
     */
    public boolean equals(Object o) {
        if (o instanceof Pet) {
            Pet pet = (Pet)o;
            if (kind.equals(pet.kind)) {
                return true;
            }      
        } 
        return false;
    }
  
  
}
