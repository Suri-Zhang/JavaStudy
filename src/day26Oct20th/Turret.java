package day26Oct20th;

import javax.swing.*;
import java.awt.*;

public class Turret extends JComponent {
    private Rectangle base;
    private Rectangle turret;
    private Color turretColor;

    public Turret(int width, int height) {
        base = new Rectangle(new Dimension(55, 30));
        turret = new Rectangle(new Dimension(15, 50));
        setBounds((width - base.width) / 2, height - base.height - turret.height - 80, width, height);
        turretColor = new Color(0xff6633);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(turretColor);
        g.fillRect(this.getX(), this.getY() + turret.height, base.width, base.height);
        g.fillRect(this.getX() + 20, this.getY(), turret.width, turret.height);
    }

}
