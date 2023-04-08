package awt;

import java.awt.*;

/**
 * @author Rex Joush
 * @time 2022.10.26
 */
public class PanelDemo {

    public static void main(String[] args) {
        // 1.创建 window 窗口对象，因为 panel 不能单独存在，只能放在 window 对象中
        Frame frame = new Frame("Panel");

        // 2.创建 panel 对象
        Panel p = new Panel();

        // 3.创建文本框和按钮放在 panel 中
        p.add(new TextField("test 文本"));
        p.add(new Button("按钮"));

        // 4.panel 放在 window 中
        frame.add(p);

        // 5.设置 window 位置和大小
        frame.setBounds(100, 100, 500, 300);

        // 6.设置 window 可见
        frame.setVisible(true);
    }

}
