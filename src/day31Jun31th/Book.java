package day31Jun31th;

public class Book extends Media {

    private String author;
    private String publisher;

    public Book() {
        super();
    }

    public Book(String uniqueID, String title, String type,
                String publisher, String author) {
        super(uniqueID, title, type);
        this.author = author;
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return getType() + ", " + getUniqueID() + ", " + getTitle() + ", " +
                getAuthor() + ", " + getPublisher();
    }
}
