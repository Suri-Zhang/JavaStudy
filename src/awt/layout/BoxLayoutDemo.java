package awt.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @author Rex Joush
 * @time 2022.10.26
 */
public class BoxLayoutDemo {

    /*
        盒子布局，swing 提供的，可以在水平和垂直方向上进行摆放 GUI 组件
        BoxLayout(Container target, int axis) 容器，布局方向
     */
    public static void main(String[] args) {
        Frame frame = new Frame("Test BoxLayout");
        // 垂直方向的布局
        BoxLayout boxLayout = new BoxLayout(frame, BoxLayout.X_AXIS);

        frame.setLayout(boxLayout);

        // 加入按钮
        frame.add(new Button("button1"));
        frame.add(new Button("button2"));

        frame.pack();
        frame.setVisible(true);
    }
}
