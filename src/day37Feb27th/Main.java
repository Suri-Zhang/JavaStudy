package day37Feb27th;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Rex Joush
 * @time 2023.02.27
 */
public class Main {

    public static void main(String[] args) {
        GenericLinkedList<Media> list = new GenericLinkedList<>();
        // read
        new Main().process(list);
        System.out.println(list);

        // sort
        list.sort();
        System.out.println(list);

        list.printBackwards();
    }

    public void process(GenericLinkedList<Media> list) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("D:\\WorkSpace\\Java\\mona\\src\\day37Feb27th\\mediaHw2.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            return;
        }
        while (scanner.hasNextLine()) {
            String uniqueID = scanner.nextLine();
            String title = scanner.nextLine();
            String type = scanner.nextLine();
            String value1 = scanner.nextLine();
            String value2 = scanner.nextLine();
            if ("book".equalsIgnoreCase(type)) {
                Book book = new Book(uniqueID, title, type,
                        value1, value2);
                list.add(book);
            } else if ("video".equalsIgnoreCase(type)) {
                Video video = new Video(uniqueID, title, type,
                        value1, value2);
                list.add(video);
            }
        }
    }

}
