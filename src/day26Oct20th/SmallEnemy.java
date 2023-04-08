package day26Oct20th;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class SmallEnemy extends Enemy {

    /**
     * This method is constructor.
     *
     * @param panelWidth  is the parameter.
     * @param panelHeight is the parameter.
     */
    public SmallEnemy(int panelWidth, int panelHeight) {
        super((new Random().nextInt(panelWidth)) - 30 * 2, (new Random().nextInt(panelHeight)) - 30 * 2,
                30, 30, 6.0);
        setColor();
    }

    /**
     * This method use for processing collision.
     *
     * @param list     is the parameter.
     * @param bigEnemy is the parameter.
     */
    @Override
    public void processCollision(ArrayList<Enemy> list, int bigEnemy) {
        Enemy enemy = list.get(bigEnemy);
        if (enemy.getWidth() - 10 > 0) {
            enemy.setSize(new Dimension(enemy.getWidth() - 10, enemy.getHeight() - 10));
        } else {
            list.remove(bigEnemy);
        }
    }

    /**
     * This method use for setting color.
     */
    @Override
    public void setColor() {
        Random r = new Random();
        Color color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
        setBackground(color);
    }

    /**
     * This method use for moving.
     *
     * @param frameWidth  is the parameter.
     * @param frameHeight is the parameter.
     */
    @Override
    public void move(int frameWidth, int frameHeight) {
//        int x = this.getX();
//        double smaEnSpeed = getEnemySpeed();
//        if (x < 0) {
//            setEnemySpeed(smaEnSpeed - 0.05);
//        } else if (x >= frameWidth) {
//            smaEnSpeed *= -1;
//        }
//        setEnemySpeed(smaEnSpeed + 0.05);
//        setBounds((int) (x + smaEnSpeed), this.getY(),
//                getWidth(), getHeight());
        int x = this.getX();
        double smaEnSpeed = getEnemySpeed();
        if (x + smaEnSpeed >= frameWidth || x + smaEnSpeed < 0) {
            smaEnSpeed *= -1;
        }
        if (smaEnSpeed > 0) {
            setEnemySpeed(smaEnSpeed + 0.05);
        } else {
            setEnemySpeed(smaEnSpeed - 0.05);
        }
        setBounds((int) (x + smaEnSpeed), this.getY(),
                getWidth(), getHeight());
    }
}
