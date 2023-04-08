package day31Jun31th;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryMachine {

    private Scanner kb = new Scanner(System.in);

    private final ArrayList<Media> list = new ArrayList<>();

    public static final String INPUT_PROMPT =
            "\nWhat would you like to do (7: Show menu): ";

    public static final String FULL_MENU = "Welcome to Media System menu:\n"
            + "    1. View the List.\n"
            + "    2. Delete a book or video.\n"
            + "    3. Add a book or vide.\n"
            + "    4. Save changes to the list to a file.\n"
            + "    0. Quit.";

    public void menu() {
        do {
            System.out.print(LibraryMachine.INPUT_PROMPT);
            switch (Integer.parseInt(kb.nextLine())) {
                case 0:
                    return; // quit
                case 1:
                    view();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    addMedia();
                    break;
                case 4:
                    writeMedia();
                    break;
                case 7: // Just print the full menu by default.
                default:
                    System.out.println(LibraryMachine.FULL_MENU);
            }
        } while (true);
    }

    private void view() {
        int i = 1;
        for (Media media : list) {
            System.out.println(i++ + ":" + media);
        }
    }

    private void delete() {
        System.out.println("Please input you want " +
                "to delete media's uniqueID.");
        String input = kb.nextLine();
        int delete = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUniqueID().equals(input)) {
                delete = i;
                break;
            }
        }
        if (delete != -1) {
            list.remove(delete);
            System.out.println("delete success!");
        }
    }

    private void addMedia() {
        System.out.println("Please input the media " +
                "what you want to add.");
        System.out.println("The uniqueID is: ");
        String uniqueID = kb.nextLine();
        System.out.println("The title is: ");
        String title = kb.nextLine();
        System.out.println("The type is: ");
        String type = kb.nextLine();
        Media media = null;
        if ("book".equals(type)) {
            System.out.println("The author is: ");
            String author = kb.nextLine();
            System.out.println("The publisher is: ");
            String publisher = kb.nextLine();
            media = new Book(uniqueID, title, "book",
                    author, publisher);
        } else if ("video".equals(type)) {
            System.out.println("The director is: ");
            String director = kb.nextLine();
            System.out.println("The format is: ");
            String format = kb.nextLine();
            media = new Video(uniqueID, title, "video",
                    director, format);
        } else {
            System.out.println("Input error");
        }
        if (checkRepeat(media)) {
            System.out.println("uniqueID or title is exist!");
            return;
        }
        list.add(media);
    }

    private boolean checkRepeat(Media m) {
        return list.contains(m);
    }

    private void writeMedia() {
        System.out.println("The file will be saved.");
        LibraryControl lc = new LibraryControl();
        lc.write(list);
    }

    public static void main(String[] args) {
        LibraryMachine lm = new LibraryMachine();
        LibraryControl lc = new LibraryControl();
        lc.process(lm.list);
        lm.menu();
    }
}
