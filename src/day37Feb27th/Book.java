package day37Feb27th;

public class Book extends Media {

    private String author;
    private String publisher;


    public Book() {
        super();
    }

    public Book(String uniqueID, String title, String type,
                String author, String publisher) {
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

    /**
     * rewrite the to string methods to control output.
     *
     * @return string content.
     */
    @Override
    public String toString() {
        return "Book [author=" + getAuthor() + ", publisher=" + getPublisher() + "," +
                " title=" + getTitle() + ", uniqueID=" + getUniqueID() + "," +
                " type=book]";
    }
}
