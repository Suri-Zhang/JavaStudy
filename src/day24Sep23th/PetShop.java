package day24Sep23th;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * A simple pet store that has pets and food things.
 */
public class PetShop {
    /**
     * The items available for sale in this pet shop. The items are
     * added to this list via the addItemsFromFile method.
     */
    private ArrayList<Thing> things;

    /**
     * This is an intermediate summary string that has been used to
     * generate the full summary format below. Don't use this one.
     * Instead, use the SUMMARY_FORMAT string below.
     */
    private static final String SUMMARY_SUB_FORMAT =
            "    Number of pets      : %d%n"
                    + "    Total price pets    : $%.2f%n"
                    + "    Number of food items: %d%n"
                    + "    Total price of food : $%.2f%n";

    /**
     * Format string to print summary of pets and food items in
     * the pet store.
     */
    private static final String SUMMARY_FORMAT =
            "Summary of items in Pet Shop%n"
                    + "Aquatic pets & food summary%n"
                    + SUMMARY_SUB_FORMAT
                    + "Non-aquatic pets & food summary%n"
                    + SUMMARY_SUB_FORMAT;

    /**
     * Format string to print food status for the pet store.
     */
    private static final String FOOD_STATUS = "Pet Shop food status:%n"
            + "    Daily aquatic food needed      : %.2f lb%n"
            + "    Daily non-aquatic food needed  : %.2f lb%n"
            + "    Aquatic food stock in store    : %.2f lb%n"
            + "    Non-aquatic food stock in store: %.2f lb%n";

    /**
     * Creates an empty shop without any items.
     */
    public PetShop() {
        things = new ArrayList<>();
    }

    /**
     * Returns the number of food objects in the list of things in
     * this pet store.
     *
     * @return The number of food things currently in the list of things in
     * this pet store.
     */
    public int getFoodCount() {
        int foodCount = 0;
        for (int i = 0; i < things.size(); i++) {
            if (things.get(i) instanceof Food) {
                foodCount++;
            }
        }
        return foodCount;
    }

    /**
     * Returns the number of pet objects in the list of things in
     * this pet store.
     *
     * @return The number of pets currently in the list of things in
     * this pet store.
     */
    public int getPetCount() {
        int petCount = 0;
        for (int i = 0; i < things.size(); i++) {
            if (things.get(i) instanceof Pet) {
                petCount++;
            }
        }
        return petCount;
    }


    /**
     * Adds items loaded from a given text file to the list of items in the
     * store. The items are stored line-by-line in the text file. Each line
     * contains values separated by a tab character. The data in the lines
     * are with:
     * 3-columns for Food:  FoodName Price Weight
     * 4-columns for Pet :  PetNamme PetKind  Price FoodPerDay
     *
     * @param fileName The text file from where Things are to be added to
     *                 the list of items for sale in the pet store.
     */
    public void addItemsFromFile(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));

        while (sc.hasNextLine()) {
            String[] fileArrayStrings = sc.nextLine().split("\\t");
            if (fileArrayStrings.length == 3) {
                if (fileArrayStrings[0].equals("WormCan")) {
                    WormCan wormCan = new WormCan(Float.parseFloat(fileArrayStrings[1]),
                            Float.parseFloat(fileArrayStrings[2]));
                    things.add(wormCan);
                } else {
                    ChowBag chowBag = new ChowBag(Float.parseFloat(fileArrayStrings[1]),
                            Float.parseFloat(fileArrayStrings[2]));
                    things.add(chowBag);
                }
            } else {
                xxx(fileArrayStrings);
            }
        }
    }

    public void xxx(String[] fileArrayStrings) {
        if (fileArrayStrings[0].equals("Cat")) {
            Cat cat = new Cat(fileArrayStrings[1], Float.parseFloat(fileArrayStrings[2]),
                    Float.parseFloat(fileArrayStrings[3]));
            things.add(cat);
        } else if (fileArrayStrings[0].equals("Dog")) {
            Dog dog = new Dog(fileArrayStrings[1], Float.parseFloat(fileArrayStrings[2]),
                    Float.parseFloat(fileArrayStrings[3]));
            things.add(dog);
        } else if (fileArrayStrings[0].equals("Fish")) {
            Fish fish = new Fish(fileArrayStrings[1], Float.parseFloat(fileArrayStrings[2]),
                    Float.parseFloat(fileArrayStrings[3]));
            things.add(fish);
        } else if (fileArrayStrings[0].equals("Octopus")) {
            Octopus octpus = new Octopus(fileArrayStrings[1], Float.parseFloat(fileArrayStrings[2]),
                    Float.parseFloat(fileArrayStrings[3]));
            things.add(octpus);
        }
    }

    /**
     * Interface method to print a summary of the items in the pet store.
     * The summary is computed and printed using the supplied
     * SUMMARY_FORMAT string.
     *
     * @see
     */
    public void printSummary() {
        int aquaticPetNum = 0;
        float aquaticPetPrice = 0f;
        int aquaticFoodNum = 0;
        float aquaticFoodPrice = 0f;
        int nonAquaticPetNum = 0;
        float nonAquaticPetPrice = 0f;
        int nonAquaticFoodNum = 0;
        float nonAquaticFoodPrice = 0f;

        for (Thing thing : things) {
            if (thing.isAquatic()) {
                if (thing instanceof Pet) {
                    aquaticPetNum++;
                    aquaticPetPrice += thing.getPrice();
                } else {
                    aquaticFoodNum++;
                    aquaticFoodPrice += thing.getPrice();
                }
            } else {
                if (thing instanceof Pet) {
                    nonAquaticPetNum++;
                    nonAquaticPetPrice += thing.getPrice();
                } else {
                    nonAquaticFoodNum++;
                    nonAquaticFoodPrice += thing.getPrice();
                }
            }
        }

        System.out.printf(SUMMARY_FORMAT, aquaticPetNum, aquaticPetPrice,
                aquaticFoodNum, aquaticFoodPrice,
                nonAquaticPetNum, nonAquaticPetPrice, nonAquaticFoodNum,
                nonAquaticFoodPrice);
    }

    /**
     * A simple method that prints all of the things in the store.
     */
    public void printAllThings() {

        System.out.println("List of all items: ");
        for (Thing thing : things) {
            if (thing instanceof Pet) {

                Pet pet = (Pet) thing;
                System.out.printf("%s\t%f\t%f\n", pet.getKind().replaceAll(";", "\\t"),
                        pet.getPrice(), pet.getFoodPerDay());

            } else {
                Food food = (Food) thing;
                System.out.printf("%s\t%f\t%f\n", food.getKind(),
                        food.getPrice(), food.getWeight());
            }
        }


    }

    /**
     * Computes and prints the amount of aquatic and non-aquatic food
     * needed to feed all of the pets in the store along with the amount
     * of food currently available. The food needed by pets is computed
     * by adding the daily food needs of all the pets. The food available
     * is computed by adding the weight of all the food things.
     *
     * @see
     */
    public void reportFoodStatus() {

        float aquaticFood = 0f;
        float nonAquaticFood = 0f;
        float aquaticStock = 0f;
        float nonAquaticStock = 0f;

        for (Thing thing : things) {
            if (thing.isAquatic()) {
                if (thing instanceof Pet) {
                    Pet pet = (Pet) thing;
                    aquaticFood += pet.getFoodPerDay();

                } else {
                    Food food = (Food) thing;
                    aquaticStock += food.getWeight();
                }
            } else {
                if (thing instanceof Pet) {
                    Pet pet = (Pet) thing;
                    nonAquaticFood += pet.getFoodPerDay();

                } else {
                    Food food = (Food) thing;
                    nonAquaticStock += food.getWeight();
                }
            }
        }
        System.out.printf(FOOD_STATUS, aquaticFood, nonAquaticFood,
                aquaticStock, nonAquaticStock);
    }
}
