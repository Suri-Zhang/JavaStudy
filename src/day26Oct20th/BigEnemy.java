package day26Oct20th;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

public class BigEnemy extends Enemy {

    /**
     * This method is the constructor, used for ensuring range.
     *
     * @param panelWidth  is the width.
     * @param panelHeight is the height.
     */
    public BigEnemy(int panelWidth, int panelHeight) {
        super(new Random().nextInt(panelWidth - 56 * 2), new Random().nextInt(panelHeight - 56 * 2),
                56, 56, 4.0);
        setColor();
    }

    /**
     * This method is override.
     *
     * @param list
     * @param bigEnemy
     */
    @Override
    public void processCollision(ArrayList<Enemy> list, int bigEnemy) {
        Enemy enemy = list.get(bigEnemy);
        if (enemy.getWidth() - 20 > 0) {
            enemy.setSize(new Dimension(enemy.getWidth() - 20, enemy.getHeight() - 20));
        } else {
            list.remove(bigEnemy);
        }
    }

    /**
     * This method set color.
     */
    @Override
    public void setColor() {
        Random r = new Random();
        Color color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
        this.setEnemyColor(color);
    }

    /**
     * This method use for moving.
     *
     * @param frameWidth  is the parameter.
     * @param frameHeight is the parameter.
     */
    @Override
    public void move(int frameWidth, int frameHeight) {
        // This method *must* change the speed of enemy when it goes outside
        // the width of the frame. That is if the x-coordinate of the enemy is
        // less than zero or greater than the frameWidth then you have to
        // change the speed by calling this.setEnemySpeed method with
        // the correct speed being positive or a negative value!
        int x = this.getX();
        double bigEnSpeed = getEnemySpeed();
        if (x + bigEnSpeed >= frameWidth || x + bigEnSpeed < 0) {
            bigEnSpeed *= -1;
        }
        setEnemySpeed(bigEnSpeed);
        setBounds((int) (x + bigEnSpeed), this.getY(),
                getWidth(), getHeight());
    }
}
