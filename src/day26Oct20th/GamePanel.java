package day26Oct20th;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JPanel;

/**
 * This class contains the paintable objects such as the enemies, turret, and
 * missile. It also keeps track of the
 *
 * @author DJ Rao
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(ArrayList<Enemy> enemyList) {
        this.enemyList = enemyList;
    }

    public ArrayList<Missile> getMissileList() {
        return missileList;
    }

    public void setMissileList(ArrayList<Missile> missileList) {
        this.missileList = missileList;
    }

    /**
     * The list of enemies in the game. Objects are added in the addEnemy
     * method and removed in the detectCollison method.
     */
    private ArrayList<Enemy> enemyList;

    /**
     * A Boolean to determine which enemy to generate next,
     * either a BigEnemy or SmallEnemy.
     */
    private boolean isNextEnemyBig;

    public Turret getTurret() {
        return turret;
    }

    public void setTurret(Turret turret) {
        this.turret = turret;
    }

    /**
     * A single Turret object to use throughout the game.
     */
    private Turret turret;

    /**
     * The list of missiles in the game. Objects are added in the addMissile
     * method and removed in the detectCollison method.
     */
    private ArrayList<Missile> missileList;

    /**
     * The current score in the game. This value is updated in the
     * detectCollision method.
     */
    private int totalScore = 0;

    public GamePanel(int windowWidth, int windowHeight) {
        setSize(windowWidth, windowHeight);
        turret = new Turret(windowWidth, windowHeight);
        missileList = new ArrayList<>();
        BigEnemy be = new BigEnemy(windowWidth / 2, windowHeight / 2);
        SmallEnemy se = new SmallEnemy(windowWidth / 2, windowHeight / 2);
        enemyList = new ArrayList<>();
        enemyList.add(be);
        enemyList.add(se);
    }


    @Override
    public void paintComponent(Graphics g) {
        for (Missile missile : missileList) {
            missile.paintComponent(g);
        }

        for (Enemy enemy : enemyList) {
            enemy.paintComponent(g);
        }
        turret.paintComponent(g);
    }

    @Override
    public void move(int frameWidth, int frameHeight) {
        for (int i = 0; i < missileList.size(); i++) {
            missileList.get(i).move(frameWidth, frameHeight,
                    missileList, i);
        }

        for (Enemy enemy : enemyList) {
            enemy.move(frameWidth, frameHeight);
        }

    }

    public void addMissile() {
        Missile m = new Missile(turret.getX() + 15, turret.getY());
        missileList.add(m);
    }

    public void addEnemy() {
        if (isNextEnemyBig) {
            isNextEnemyBig = false;
            Enemy be = new BigEnemy(getWidth(), getHeight());
            enemyList.add(be);
        } else {
            isNextEnemyBig = true;
            Enemy se = new SmallEnemy(getWidth(), getHeight());
            enemyList.add(se);
        }
    }

    public int getTotalScore() {
        return totalScore;
    }

    /**
     * Method detects the collision of the missile and all the enemies. This is
     * done by drawing invisible rectangles around the enemies and missiles, if
     * they intersect, then they collide.
     */
    public void detectCollision() {
        // Uses bounds for enemies and missiles to detect intersection.
        for (int i = 0; i < enemyList.size(); i++) {
            Rectangle enemyRec = enemyList.get(i).getBounds();
            for (int j = 0; j < missileList.size(); j++) {
                Rectangle missileRec = missileList.get(j).getBounds();
                if (missileRec.intersects(enemyRec)) {
                    // Missile has hit an enemy!
                    enemyList.get(i).processCollision(enemyList, i);
                    missileList.remove(j);
                    if (enemyList.get(i) instanceof BigEnemy) {
                        totalScore += 100;
                    } else {
                        totalScore += 150;
                    }
                }
            }
        }

    }
}
