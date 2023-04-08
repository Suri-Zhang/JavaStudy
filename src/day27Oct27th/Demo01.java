package day27Oct27th;

import javax.swing.*;
import java.awt.*;

/**
 * @author Rex Joush
 * @time 2022.10.27
 */
public class Demo01 {

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setBounds(100, 100, 200, 300);

        Panel panelTop = new Panel();
        Button button1 = new Button("button1");
        button1.setBounds(10, 10 , 20, 30);
        panelTop.add(button1);


        Panel panelBottom = new Panel();
        Button button2 = new Button("button2");
        button2.setBounds(10, 10 , 20, 30);
        panelBottom.add(button2);

        Box panel = Box.createHorizontalBox();
        panel.add(panelTop);
        panel.add(panelBottom);

        frame.add(panel);
        frame.setVisible(true);
    }

}
