package awt.layout;

import java.awt.*;

/**
 * @author Rex Joush
 * @time 2022.10.26
 */
public class BorderLayoutDemo2 {

    public static void main(String[] args) {
        // 空参，使用默认的水平间距和垂直间距创建 BorderLayout 布局
        BorderLayout borderLayout = new BorderLayout();

        Frame frame = new Frame("Test BorderLayout");
        frame.setLayout(borderLayout);
        // 在 frame 的指定区域添加按钮
        frame.add(new Button("North"), BorderLayout.NORTH);
        frame.add(new Button("South"), BorderLayout.SOUTH);

        Panel p = new Panel();
        p.add(new Button("Center"));
        p.add(new TextField("test text"));
        frame.add(p, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

}
