package awt.event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Rex Joush
 * @time 2022.10.26
 */
public class EventDemo01 {

    Frame frame = new Frame("Test Event");
    TextField textField = new TextField(30);
    Button ok = new Button("confirm");
    private void init() {

        // 创建监听器
        MyListener myListener = new MyListener();

        // 注册监听
        ok.addActionListener(myListener);

        // 组装
        frame.add(textField, BorderLayout.NORTH);
        frame.add(ok);

        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new EventDemo01().init();
    }

    private class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            textField.setText("Hello World");
        }
    }

}
