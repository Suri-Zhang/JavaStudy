package awt.compoment;

import javax.swing.*;
import java.awt.*;

/**
 * @author Rex Joush
 * @time 2022.10.26
 */
public class BasicComponent {

    JFrame frame = new JFrame("Test Basic Component");

    JTextArea textArea = new JTextArea(5, 20);

    Choice choice = new Choice();

    CheckboxGroup checkboxGroup = new CheckboxGroup();
    Checkbox male = new Checkbox("male", checkboxGroup, true);
    Checkbox female = new Checkbox("female", checkboxGroup, true);

    Checkbox isMarried = new Checkbox("married?");

    JTextField textField = new JTextField(50);

    JButton button = new JButton("confirm");

    List colorList = new List(6, true);

    private void init() {

        Box pSouth = Box.createHorizontalBox();
        pSouth.add(textField);
        pSouth.add(button);

        frame.add(pSouth, BorderLayout.NORTH);
        Box pNorth = Box.createHorizontalBox();

        choice.add("red");
        choice.add("greed");
        choice.add("blue");

        Box pLeft = Box.createVerticalBox();
        pLeft.add(textArea);
        Box leftDown = Box.createHorizontalBox();
        leftDown.add(choice);
        leftDown.add(male);
        leftDown.add(female);
        leftDown.add(isMarried);
        pLeft.add(leftDown);

        pNorth.add(pLeft);
        colorList.add("red");
        colorList.add("green");
        colorList.add("blue");
        pNorth.add(colorList);
        frame.add(pNorth);

        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new BasicComponent().init();
    }



}
