package awt.layout;

import java.awt.*;

/**
 * @author Rex Joush
 * @time 2022.10.26
 */
public class GridLayoutDemo {

    /*
        网格布局管理器，每个网格所占大小相同
        添加组件的时候，默认从左向右，从上到下依次添加在每个网格中
        构造方法：
            GridLayout(int rows, int cols); 指定行列数
            GridLayout(int rows, int cols, int hgap, int vgap); 指定行列数和空隙
     */
    public static void main(String[] args) {
        Frame frame = new Frame("calc");

        // 1.创建 panel 对象，存放 textFiled 组件
        Panel p = new Panel();
        p.add(new TextField(30)); // 30个字符

        // 2.当前 panel 添加到 北边区域
        frame.add(p, BorderLayout.NORTH);

        // 3.创建 panel 对象，设置布局为 grid
        Panel panel = new Panel();

        // 4.添加内容
        panel.setLayout(new GridLayout(3, 5, 5, 5));

        for (int i = 0; i < 10; i++) {
            panel.add(new Button(String.valueOf(i)));
        }
        panel.add(new Button("+"));
        panel.add(new Button("-"));
        panel.add(new Button("*"));
        panel.add(new Button("/"));
        panel.add(new Button("."));
        // 5.将当前 panel 加到 frame 中
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

}
