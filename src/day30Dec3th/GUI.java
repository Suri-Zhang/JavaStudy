package day30Dec3th;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Rex Joush
 * @time 2022.12.03
 */
public class GUI implements ActionListener {
    public JTextField field1 = new JTextField();
    public JTextField field2 = new JTextField();
    public JButton  clear = new JButton("clear");
    public JButton equals = new JButton("equals");
    public JLabel result  = new JLabel();

    public GUI() {
        clear.setActionCommand("clear");
        equals.setActionCommand("equals");
        clear.addActionListener(this);
        equals.addActionListener(this);
        // Assume remainder of constructor lays out the GUI
        Frame frame = new Frame("Practice Exam");
        Panel p = new Panel();
        p.add(new Button("Center"));
        p.add(new TextField("test text"));
        Box display = Box.createHorizontalBox();
        display.add(field1);
        display.add(field2);

        frame.add(display, BorderLayout.NORTH);
        frame.add(result, BorderLayout.CENTER);

        Box buttons = Box.createHorizontalBox();
        buttons.add(clear);
        buttons.add(equals);
        frame.add(buttons, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("clear")) {
            field1.setText("");
            field2.setText("");
            return;
        }

        if (command.equals("equals")) {
            String field1Text = field1.getText();
            String field2Text = field2.getText();
            if (field1Text.equals(field2Text)) {
                result.setText("true");
            } else {
                result.setText("false");
            }
        }
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}

