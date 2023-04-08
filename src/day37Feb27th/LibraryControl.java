package day37Feb27th;

import day31Jun31th.Book;
import day31Jun31th.Media;
import day31Jun31th.MediaType;
import day31Jun31th.Video;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class LibraryControl {

    public void process(List<day31Jun31th.Media> list) {
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
                day31Jun31th.Book book = new day31Jun31th.Book(uniqueID, title, type,
                        value1, value2);
                list.add(book);
            } else if (MediaType.Video.equals(type)) {
                day31Jun31th.Video video = new day31Jun31th.Video(uniqueID, title, type,
                        value1, value2);
                list.add(video);
            }
        }
    }

    public void write(List<day31Jun31th.Media> list) {
        try {
            PrintWriter out = new PrintWriter("media.txt");
            for (Media media : list) {
                out.println(media.getUniqueID());
                out.println(media.getTitle());
                out.println(media.getType());

                if (media instanceof day31Jun31th.Book) {
                    day31Jun31th.Book book = (Book) media;
                    out.println(book.getAuthor());
                    out.println(book.getPublisher());
                } else {
                    day31Jun31th.Video video = (Video) media;
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
