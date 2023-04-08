package day29Nov17th;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class acts as a warehouse that maintains the list of media items
 * Media items can be added, searched, and priced.
 */
public class MediaWarehouse {
    /**
     * The list of media currently available in this warehouse. This list is
     * initialized to an empty list in the constructor.
     */
    private ArrayList<Media> mediaList;

    /**
     * The default constructor merely initializes the instance variables.
     */
    public MediaWarehouse() {
        mediaList = new ArrayList<>();
    }

    /**
     * Helper method to find the media object associated with a given upc
     * in the mediaList.
     *
     * @param upc The UPC to search for in the current mediaList.
     * @return This method returns the media item if it is found. Otherwise,
     * this method returns null.
     */
    public Media findMedia(String upc) {
        for (Media media : mediaList) {
            if (media.getUpc().equals(upc)) {
                return media;
            }
        }
        return null;  // when media with given upc not found.
    }

    /**
     * Print the list of media in the mediaList.
     */
    public void printMedia() {
        // Implement this method. It is a simple one.
        System.out.println("Currently loaded media:");
        System.out.println();
        for (Media media : mediaList) {
            System.out.println(media);
        }
    }


    /**
     * Searches for the given phrase in each media's UPC and title. The method
     * prints the media objects that contain the phrase. This method also
     * prints a summary message of the form --
     * "Found 5 matches, out of 17 media items." at the end. See sample outputs
     * in project document for more examples.
     *
     * @param phrase The substring to search for.
     * @note The search is case-insensitive. So all strings must be first
     * converted to lower case prior to using them.
     */
    public void search(String phrase) {
        // Convert sub-name to lower case to streamline the search
        int count = 0;
        for (Media media : mediaList) {
            if (media.getUpc().toLowerCase().contains(phrase.toLowerCase()) ||
                    media.getTitle().toLowerCase().contains(phrase.toLowerCase())) {
                System.out.println(media);
                count++;
            }
        }
        // Print the number of bundles found.
        System.out.println("Found " + count + " matches, out of " + mediaList.size() + " media items.");
    }

    /**
     * This method is called to load data from either a text file or a binary
     * file. For text file formats see 90s_media.txt for example. The binary
     * file is read as a single object (using an ObjectInputStream) of
     * ArrayList type. The media loaded is added to the mediaList
     * instance variable in this class. This method does not add duplicate
     * media items -- i.e. media with the same UPC are duplicates. If a
     * duplicate media item is found it prints an message stating with the
     * duplicate upc in the form -- "Duplicate media with upc m_90_2 ignored".
     *
     * @param filePath Path (relative or absolute) to the file from where the
     *                 media is to be added to the current
     * @param isText   If this flag is true, then the file is a text file.
     *                 Otherwise the file is a binary file (created via prior
     *                 call to the writeMedia method in this class.
     * @return This method returns the number of new media items added
     * from the file.
     * @throws IOException            When I/O errors occur
     * @throws ClassNotFoundException When loading binary media object fails
     * @note It may be best to create a helper method that checks and adds
     * non-duplicate media.
     */
    public int addMediaFrom(String filePath, boolean isText) throws IOException, ClassNotFoundException {
        int items = 0;

        if (!isText) {
            items = readBin(filePath);
        } else {
            items = readText(filePath);
        }
        return items;  // this is a dummy return. remove it.
    }

    public int readText(String filePath) throws FileNotFoundException {
        int items = 0;
        Scanner input = new Scanner(new File(filePath));
        while (input.hasNextLine()) {
            String s = input.nextLine();
            Media load;
            if (s.charAt(0) == 'A') {
                load = Audio.load(s);
            } else {
                load = Video.load(s);
            }
            if (!contains(load)) {
                mediaList.add(load);
                items++;
            } else {
                System.out.println("Duplicate media with " +
                        "upc " + load.getUpc() + " ignored");
            }
        }
        input.close();
        return items;
    }

    public int readBin(String filePath) throws IOException, ClassNotFoundException {
        int items = 0;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
//        while (objectInputStream.available() > 0) {
//            Media media = (Media) objectInputStream.readObject();
//            if (!contains(media)) {
//                mediaList.add(media);
//                items++;
//            } else {
//                System.out.println("Duplicate media with " +
//                        "upc " + media.getUpc() + " ignored");
//            }
//        }
//        objectInputStream.close();
        mediaList = (ArrayList<Media>) objectInputStream.readObject();
        return mediaList.size();
    }

    public boolean contains(Media media) {
        for (Media m : mediaList) {
            if (m.getUpc().equals(media.getUpc())) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called to write each entry in the mediaList to a given
     * file in text or binary format. The text format is generated by simply
     * printing each media entry. The binary format is generated by writing
     * the whole mediaList ArrayList as a single object using an
     * ObjectOutputStream.
     *
     * @param filePath The path to the output file. If the file exists, then the
     *                 contents is overwritten.
     * @param isText   If this flag is true, then the output is written as text.
     *                 Otherwise the output is written in binary format.
     * @throws IOException This exception is exposed if any I/O error occurs.
     */
    public void writeMedia(String filePath, boolean isText) throws IOException {
        // Implement this method for both text and binary I/O
        File file = new File(filePath);
        if (!file.isFile()) {
            file.createNewFile();
        }
        if (!isText) {
             writeBin(filePath);
        } else {
             writeText(filePath);
        }

    }

    private void writeText(String filePath) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filePath);
        for (Media media : mediaList) {
            writer.println(media);
        }
        writer.close();
    }

    private void writeBin(String filePath) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        objectOutputStream.writeObject(mediaList);
        objectOutputStream.close();
    }

    /**
     * <p>Computes the total price of a set of media items to be purchased as a
     * bundle. Note that a totalPrice is computed by adding the price for each
     * media item. After that, the following formula is used to adjust the price
     * of the bundle:
     * </p>
     * <p>
     * finalPrice = totalPrice + (hdcpCount * 0.10) - (operaCount * 0.05)
     * </p>
     * where, hdcpCount is number of Video objects for which isHdcp returns true
     * and operaCount is number of Audio objects for which isOperatic is true
     *
     * @param upcList The list of items whose total price is to be computed.
     * @return The total price of the list of items.
     */
    public float computeTotalPrice(ArrayList<String> upcList) {
        float totalPrice = 0;
        int hdcpCount = 0;
        int operaCount = 0;

        for (Media media : mediaList) {
            if (!upcList.contains(media.getUpc())) {
                continue;
            }
            totalPrice += media.getPrice();
            if (media instanceof Audio) {
                Audio audio = (Audio) media;
                if (audio.isOperatic()) {
                    operaCount++;
                }
            }

            if (media instanceof Video) {
                Video video = (Video) media;
                if (video.isHdcp()) {
                    hdcpCount++;
                }
            }

        }
        double finalPrice = totalPrice + (hdcpCount * 0.10) - (operaCount * 0.05);  // dummy return; remove it.
        return (float) finalPrice;
    }
}
