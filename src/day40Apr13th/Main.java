import java.io.FileNotFoundException;

/**
 * This is a main method
 */
public class Main {
    /**
     * The main method.
     * @param args parameter.
     * @throws FileNotFoundException ensure there is no exception.
     */
    public static void main(String[] args) throws FileNotFoundException {
        AppearTime appearTime = new AppearTime();
        appearTime.sorted("warAndPeace.txt");
    }
}
