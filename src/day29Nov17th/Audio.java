package day29Nov17th;

import java.io.Serializable;
import java.util.Scanner;

public class Audio extends Media implements Serializable, Comparable<Audio> {
    private long serialVersionUID;
    private int billboardRank;
    private boolean operatic;
    private String AUDIO_FORMAT = "Audio\t%s\t%s\t%d\t%.2f\t%d\t%b";

    public Audio(String upc, String title, int year) {
        super(upc, title, year);
    }

    public int getBillboardRank() {
        return billboardRank;
    }

    public void setBillboardRank(int billboardRank) {
        this.billboardRank = billboardRank;
    }

    public boolean isOperatic() {
        return operatic;
    }

    public void setOperatic(boolean operatic) {
        this.operatic = operatic;
    }


    public String toString() {

        return String.format(AUDIO_FORMAT, getUpc(), getTitle(), getYear(), getPrice(), this.billboardRank, this.operatic);
    }

    @Override
    public int compareTo(Audio o) {
        int res = this.billboardRank - o.billboardRank;
        if (res != 0) {
            return res;
        }
        float res2 = this.getPrice() - o.getPrice();
        if (res2 != 0) {
            return res2 > 0 ? 1 : -1;
        }

        return this.getTitle().compareTo(o.getTitle());

    }

    public static Audio load(String info) {
        //Audio m_90_1 Hold On 1990 1.99 1 false
        Scanner in = new Scanner(info).useDelimiter("\\t");
        in.next();
        String upc = in.next();
        String name = in.next();
        int year = in.nextInt();

//        Audio audio = new Audio(in.next(), in.next(), in.nextInt());
        Audio audio = new Audio(upc, name, year);

        audio.setPrice(in.nextFloat());
        audio.setBillboardRank(in.nextInt());
        audio.setOperatic(Boolean.parseBoolean(in.next()));
        return audio;
    }
}
