package day26Oct20th;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Missile extends JComponent {

    private int missileSpeed;
    private Color missileColor;

    /**
     * This method is the constructor.
     *
     * @param x is the parameter.
     * @param y is the parameter.
     */
    public Missile(int x, int y) {
        this.setBounds(x, y, 15, 15);
        this.missileSpeed = 5;
        Random r = new Random();
        this.missileColor = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(missileColor);
        setSize(15, 15);
        g.fillOval(this.getX(), this.getY(), getWidth(), getHeight());
    }

    /**
     * This method use for moving.
     *
     * @param panelWidth  is the parameter.
     * @param panelHeight is the parameter.
     * @param list        is the parameter.
     * @param missile     is the parameter.
     */
    public void move(int panelWidth, int panelHeight, ArrayList<Missile> list,
                     int missile) {
        Missile miss = list.get(missile);
        if (miss.getY() > panelHeight || miss.getX() > panelWidth) {
            list.remove(missile);
            return;
        }
        setBounds(miss.getX(), miss.getY() - missileSpeed, panelWidth, panelHeight);
    }

    /**
     * This method get speed.
     *
     * @return speed.
     */
    public int getMissileSpeed() {
        return missileSpeed;
    }

    /**
     * This method use for setting speed.
     *
     * @param missileSpeed is the parameter.
     */
    public void setMissileSpeed(int missileSpeed) {
        this.missileSpeed = missileSpeed;
    }

    /**
     * This method use for getting color.
     *
     * @return color.
     */
    public Color getMissileColor() {
        return missileColor;
    }

    /**
     * This method use for setting color.
     *
     * @param missileColor is the parameter.
     */
    public void setMissileColor(Color missileColor) {
        this.missileColor = missileColor;
    }
}

