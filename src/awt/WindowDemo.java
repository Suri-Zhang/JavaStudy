package awt;

import java.awt.*;

/**
 * @author Rex Joush
 * @time 2022.10.26
 */
public class WindowDemo {

    public static void main(String[] args) {
        // 1.创建窗口对象
        Frame frame = new Frame();

        // 2.指定大小和位置
        frame.setLocation(100, 100);
        frame.setSize(500, 300);

        // 3.设置窗口可见
        frame.setVisible(true);
    }

}
