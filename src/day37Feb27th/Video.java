package day37Feb27th;

public class Video extends Media {
    private String format;
    private String director;

    /**
     * Empty constructor.
     */
    public Video() {

    }

    /**
     * The constructor has parameter and body content.
     *
     * @param uniqueID by super to get.
     * @param title    by super to get.
     * @param type     by super to get.
     * @param format   get director.
     * @param director get format.
     */
    public Video(String uniqueID, String title, String type, String director, String format) {
        super(uniqueID, title, type);
        this.director = director;
        this.format = format;
    }

    /**
     * getting method to get director.
     *
     * @return director.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Setting method to set director.
     *
     * @param director to set the variable.
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Getting methods, to get format.
     *
     * @return format.
     */
    public String getFormat() {
        return format;
    }

    /**
     * Setting methods to set format.
     *
     * @param format to set variable.
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * rewrite the to string methods to control output.
     *
     * @return string content.
     */
    public String toString() {
        return "Video [director=" + getDirector() + ", format=" + getFormat() + "," +
                " title=" + getTitle() + ", uniqueID=" + getUniqueID() + "," +
                " type=video]";
    }


}
