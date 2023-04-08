package awt.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @author Rex Joush
 * @time 2022.10.26
 */
public class BoxLayoutDemo2 {

    /*
        swing 提供了新的容器 Box，默认布局即是 BoxLayout，大多数情况下使用 Box 容器容纳多个 GUI 组件
        再把 Box 作为组件，加到其他容器中
        static Box createHorizontalBox(); // 水平容器
        static Box createVerticalBox();   // 垂直容器

        static Component createHorizontalGlue(); 创建一个水平间距, 相当于 span
        static Component createVerticalGlue(); 创建一个水平间距, 相当于 span
        static Component createHorizontalStruct(int width); 创建一个水平间距指定宽度的间距，不能拉伸
        static Component createVerticalStruct(int height); 创建一个垂直间距指定宽度的间距，不能拉伸
     */
    public static void main(String[] args) {
        Frame frame = new Frame("Test Box");
        // 水平排列的容器
        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(new Button("hor1"));
        horizontalBox.add(new Button("hor2"));

        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(new Button("ver1"));
        verticalBox.add(new Button("ver2"));
        frame.add(horizontalBox, BorderLayout.NORTH);
        frame.add(verticalBox);

        frame.pack();
        frame.setVisible(true);
    }
}
