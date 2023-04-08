package awt.layout;

import java.awt.*;

/**
 * @author Rex Joush
 * @time 2022.10.26
 */
public class BorderLayoutDemo {

    /*
        将区域分成五部分，上北，下南，左西，右东，中间
     */
    public static void main(String[] args) {
        // 空参，使用默认的水平间距和垂直间距创建 BorderLayout 布局
        BorderLayout borderLayout1 = new BorderLayout();

        // 空参，使用指定的水平间距和垂直间距创建 BorderLayout 布局
        BorderLayout borderLayout2 = new BorderLayout(10, 20);

        Frame frame = new Frame("Test BorderLayout");
        frame.setLayout(borderLayout2);
        // 在 frame 的指定区域添加按钮
        frame.add(new Button("North"), BorderLayout.NORTH);
        frame.add(new Button("South"), BorderLayout.SOUTH);
        frame.add(new Button("West"), BorderLayout.WEST);
        frame.add(new Button("East"), BorderLayout.EAST);
        frame.add(new Button("Center"), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

}
