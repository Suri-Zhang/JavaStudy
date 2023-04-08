package awt.event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

/**
 * @author Rex Joush
 * @time 2022.10.27
 */
public class MouseEvent {

    Frame frame = new Frame("Test");

    private void init() {

        frame.setSize(new Dimension(700, 500));

        Panel panel = new Panel();
        Button button = new Button("Button");

        panel.add(button);


        MouseListener listener = new MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                button.setLocation(x, y);
            }
        };

        panel.addMouseListener(listener);

        frame.add(panel);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new MouseEvent().init();
    }


}
