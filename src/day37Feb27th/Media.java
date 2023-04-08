package day37Feb27th;

public abstract class Media implements Comparable<Media> {

    private String uniqueID;
    private String title;
    private String type;

    /**
     * empty constructor.
     */
    public Media() {
    }

    /**
     * Constructor with parameter.
     *
     * @param uniqueID to get variable.
     * @param title    to get variable.
     * @param type     to get variable.
     */
    public Media(String uniqueID, String title, String type) {
        this.uniqueID = uniqueID;
        this.title = title;
        this.type = type;
    }

    /**
     * Getting method.
     *
     * @return title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * setting methods.
     *
     * @param title set variable.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * getting methods.
     *
     * @return type.
     */
    public String getType() {
        return type;
    }

    /**
     * Setting method.
     *
     * @param type set variable.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * getting method.
     *
     * @return uniqueID.
     */
    public String getUniqueID() {
        return uniqueID;
    }

    /**
     * Setting method.
     *
     * @param uniqueID set variable.
     */
    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    /**
     * rewrite the to contains methods to compare.
     *
     * @return true or false.
     */
    @Override
    public boolean equals(Object obj) {
        Media media = (Media) obj;
        return this.uniqueID.equals(media.uniqueID) ||
                this.title.equals(media.title);
    }

    public int compareTo(Media m) {
        return uniqueID.compareTo(m.uniqueID);
    }
}
