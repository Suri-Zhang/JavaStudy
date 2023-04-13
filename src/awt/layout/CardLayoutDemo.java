package awt.layout;

import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Rex Joush
 * @time 2022.10.26
 */
public class CardLayoutDemo {

    /*
        卡片布局，以时间来管理，将加入的组件看成一叠叠卡牌，每次只有最上面的组件能看见
        CardLayout() 创建布局
        CardLayout(int hgap, int vgap) 创建布局，与容器左右边界的减去来创建布局

        first(Container target) 显示容器的第一张卡片
        last(Container target) 显示容器的最后一张卡片
        previous(Container target) 显示容器的前一张卡片
        next(Container target) 显示容器的后一张卡片
        show(Container target, String name) 显示容器的指定名字的一张卡片
     */

    public static void main(String[] args) {
        Frame frame = new Frame();

        // 创建卡片区域
        Panel cards = new Panel();
        CardLayout cardLayout = new CardLayout();
        cards.setLayout(cardLayout);
        // 添加多个组件
        for (int i = 0; i < 5; i++) {
            cards.add(String.valueOf(i + 1), new Button(String.valueOf(i + 1)));
        }

        frame.add(cards);

        // 创建操作区域
        Panel action = new Panel();

        // 添加五个 button
        Button b1 = new Button("prev");
        Button b2 = new Button("next");
        Button b3 = new Button("first");
        Button b4 = new Button("last");
        Button b5 = new Button("third");

        ActionListener listener = e -> {
            switch (e.getActionCommand()) {
                case "prev":
                    cardLayout.previous(cards);
                    break;
                case "next":
                    cardLayout.next(cards);
                    break;
                case "first":
                    cardLayout.first(cards);
                    break;
                case "last":
                    cardLayout.last(cards);
                    break;
                case "third":
                    cardLayout.show(cards, "3");
                    break;
            }
        };

        // 将按钮绑定到监听器上
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);

        action.add(b1);
        action.add(b2);
        action.add(b3);
        action.add(b4);
        action.add(b5);

        frame.add(action, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

}
