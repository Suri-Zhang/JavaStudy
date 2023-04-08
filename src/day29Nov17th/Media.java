package day29Nov17th;

import java.io.Serializable;

public class Media implements Serializable {
    private String upc;
    private String title;
    private int year;
    private float price;
    private long serialVersionUID;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String ups) {
        this.upc = upc;
    }

    public Media(String upc, String title, int year) {
        this.upc = upc;
        this.title = title;
        this.year = year;
    }

    public Media(String upc, String title, int year, float price) {
        this.upc = upc;
        this.title = title;
        this.year = year;
        this.price = price;
    }
}
