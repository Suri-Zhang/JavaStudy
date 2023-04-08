package day31Jun31th;

public class Video extends Media {

    private String director;
    private String format;

    public Video() {
    }

    public Video(String uniqueID, String title, String type,
                 String director, String format) {
        super(uniqueID, title, type);
        this.director = director;
        this.format = format;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String toString() {
        return getType() + ", " + getUniqueID() + ", " + getTitle() + ", " +
                getDirector() + ", " + getFormat();
    }
}
