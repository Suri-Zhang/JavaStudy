package awt.paint;

import java.awt.*;

/**
 * @author Rex Joush
 * @time 2022.10.26
 */
public class PaintDemo01 {

    /*
        paint(Graphics g) // 绘图
        update(Graphics g) // 刷新绘图
        repaint(Graphics g) // 调用 update, 刷新外观

        画图步骤
            1.自定义类，继承 Canvas，重写 paint 方法
            2.在 paint 方法内部，调用 setColor, setFont 等设置
            3.调用 drawXxx开始画图
     */

    private final String RECT_SHAPE = "rect";
    private final String OVAL_SHAPE = "oval";

    private String shape = "";

    private Frame frame = new Frame("Test Paint");

    Button button1 = new Button("draw Rect");
    Button button2 = new Button("draw Oval");

    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            if (shape.equals(RECT_SHAPE)) {
                // 绘制矩形
                g.setColor(Color.BLACK);
                g.fillOval(100, 100, 200, 100);
            } else {
                // 绘制椭圆
                g.setColor(Color.RED);
                g.fillOval(100, 100, 200, 100);
            }
        }
    }

    MyCanvas myCanvas = new MyCanvas();

    public void init() {
        // 组装视图
        button1.addActionListener(e -> {
            // 修改标记
            shape = RECT_SHAPE;
            myCanvas.repaint();
        });
        button2.addActionListener(e -> {
            // 修改标记
            shape = OVAL_SHAPE;
            myCanvas.repaint();
        });

        // 创建 panel
        Panel panel = new Panel();
        panel.add(button1);
        panel.add(button2);

        frame.add(panel, BorderLayout.SOUTH);

        // 设置画布大小
        myCanvas.setPreferredSize(new Dimension(300, 300));

        frame.add(myCanvas);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PaintDemo01().init();
    }
}
