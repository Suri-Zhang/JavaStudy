package day31Jun31th;

public abstract class Media {

    private String uniqueID;
    private String title;
    private String type;

    public Media() {
    }

    public Media(String uniqueID, String title, String type) {
        this.uniqueID = uniqueID;
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    @Override
    public boolean equals(Object obj) {
        Media media = (Media) obj;
        return this.uniqueID.equals(media.uniqueID) &&
                this.title.equals(media.title);
    }
}
