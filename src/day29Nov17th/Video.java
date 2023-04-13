package day29Nov17th;

import java.io.Serializable;
import java.util.Scanner;


public class Video extends Media implements Serializable, Comparable<Video> {

    private long serialVersionUID;
    private String mpaa;
    private boolean hdcp;

    private String VIDEO_FORMAT = "Video\t%s\t%s\t%d\t%.2f\t%s\t%b";

    public String getMpaa() {
        return mpaa;
    }

    public void setMpaa(String mpaa) {
        this.mpaa = mpaa;
    }

    public Video(String upc, String title, int year) {
        super(upc, title, year);
    }

    public boolean isHdcp() {
        return hdcp;
    }

    public void setHdcp(boolean hdcp) {
        this.hdcp = hdcp;
    }

    @Override
    public int compareTo(Video o) {
        int res = this.mpaa.compareTo(o.mpaa);
        if (res != 0) {
            return res;
        }
        float res2 = this.getPrice() - o.getPrice();
        if (res2 != 0) {
            return res2 > 0 ? 1 : -1;
        }

        return this.getTitle().compareTo(o.getTitle());

    }


    @Override
    public String toString() {

        return String.format(VIDEO_FORMAT, getUpc(), getTitle(), getYear(), getPrice(), this.mpaa, this.hdcp);
    }

    public static Video load(String info) {

        //Video lo_90_1 Prescription for Death 1990 0.99 PG false
        //Video lo_91_1 Confession 1991 0.99 PG false

        Scanner in = new Scanner(info).useDelimiter("\\t");
        in.next();
        Video video = new Video(in.next(), in.next(), in.nextInt());
        video.setPrice(in.nextFloat());
        video.setMpaa(in.next());
        video.setHdcp(Boolean.parseBoolean(in.next()));

        return video;
    }


}
