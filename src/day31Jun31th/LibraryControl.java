package day31Jun31th;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class LibraryControl {

    public void process(List<Media> list) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("media.txt"));
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
            if (MediaType.Book.equals(type)) {
                Book book = new Book(uniqueID, title, type,
                        value1, value2);
                list.add(book);
            } else if (MediaType.Video.equals(type)) {
                Video video = new Video(uniqueID, title, type,
                        value1, value2);
                list.add(video);
            }
        }
    }

    public void write(List<Media> list) {
        try {
            PrintWriter out = new PrintWriter("media.txt");
            for (Media media : list) {
                out.println(media.getUniqueID());
                out.println(media.getTitle());
                out.println(media.getType());

                if (media instanceof Book) {
                    Book book = (Book) media;
                    out.println(book.getAuthor());
                    out.println(book.getPublisher());
                } else {
                    Video video = (Video) media;
                    out.println(video.getDirector());
                    out.println(video.getFormat());
                }
                out.flush();
            }
            out.close();
            System.out.println("write success");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

}
