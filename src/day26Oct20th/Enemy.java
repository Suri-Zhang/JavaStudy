package day26Oct20th;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class Enemy extends JComponent {

    private double enemySpeed;
    private Color enemyColor;

    public Enemy(int x, int y, int width, int height, double enemySpeed) {
        this.setBounds(x, y, width, height);
        this.enemySpeed = enemySpeed;
        Random r = new Random();
        this.enemyColor = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    public abstract void processCollision(ArrayList<Enemy> list, int enemy);

    public abstract void setColor();

    public abstract void move(int frameWidth, int frameHeight);

    @Override
    public void paintComponent(Graphics g) {
        Rectangle bounds = this.getBounds();
        g.setColor(enemyColor);
        g.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public double getEnemySpeed() {
        return enemySpeed;
    }

    public void setEnemySpeed(double enemySpeed) {
        this.enemySpeed = enemySpeed;
    }

    public Color getEnemyColor() {
        return enemyColor;
    }

    public void setEnemyColor(Color enemyColor) {
        this.enemyColor = enemyColor;
    }
}