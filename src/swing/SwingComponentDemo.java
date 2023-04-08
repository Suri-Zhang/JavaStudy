package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Rex Joush
 * @time 2022.10.26
 */
public class SwingComponentDemo {

    JFrame f = new JFrame("Test swing");

    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("file");
    JMenu edit = new JMenu("edit");

    JMenuItem auto = new JMenuItem("auto-enter");
    JMenuItem copy = new JMenuItem("copy");
    JMenuItem paste = new JMenuItem("paste");

    JMenu format = new JMenu("format");
    JMenuItem comment = new JMenuItem("comment");
    JMenuItem uncomment = new JMenuItem("uncomment");

    // 声明文本
    JTextArea textArea = new JTextArea(8, 20);

    // 列表框
    String[] colors = new String[]{"red", "green", "blue"};
    JList<String> colorList = new JList<>(colors);

    // 选择器相关
    JComboBox<String> colorSelect = new JComboBox<>();

    ButtonGroup sexButtonGroup = new ButtonGroup();
    JRadioButton male = new JRadioButton("male", false);
    JRadioButton female = new JRadioButton("female", true);

    JCheckBox isMarried = new JCheckBox("married?", true);

    JTextField textField = new JTextField(40);
    JButton confirm = new JButton("confirm");

    // 右键菜单
    JPopupMenu popupMenu = new JPopupMenu();

    ButtonGroup popupButtonGroup = new ButtonGroup();

    JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal");
    JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus");
    JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows");
    JRadioButtonMenuItem windowSClassicItem = new JRadioButtonMenuItem("WindowSClassic", true);
    JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif");

    public void init() {
        // 组装视图
        colorSelect.addItem("red");
        colorSelect.addItem("green");
        colorSelect.addItem("blue");

        // 底部
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(textArea);
        bottomPanel.add(confirm);

        f.add(bottomPanel, BorderLayout.SOUTH);

        // 选择相关组件
        JPanel selectPanel = new JPanel();
        selectPanel.add(colorSelect);
        sexButtonGroup.add(male);
        sexButtonGroup.add(female);
        selectPanel.add(male);
        selectPanel.add(female);

        selectPanel.add(isMarried);

        // 组装文本域和选择组件
        Box topLeft = Box.createVerticalBox();
        topLeft.add(textArea);
        topLeft.add(selectPanel);

        Box top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);
        f.add(top);

        // 放入菜单相关内容
        format.add(comment);
        format.add(uncomment);

        edit.add(auto);
        edit.addSeparator();
        edit.add(copy);
        edit.add(paste);
        edit.addSeparator();
        edit.add(format);

        menuBar.add(file);
        menuBar.add(edit);

        f.setJMenuBar(menuBar);

        // 右键菜单
        popupButtonGroup.add(metalItem);
        popupButtonGroup.add(nimbusItem);
        popupButtonGroup.add(windowsItem);
        popupButtonGroup.add(windowSClassicItem);
        popupButtonGroup.add(motifItem);

        ActionListener listener = e -> {
            try {
                changeFlavor(e.getActionCommand());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };

        popupMenu.add(metalItem);
        popupMenu.add(nimbusItem);
        popupMenu.add(windowsItem);
        popupMenu.add(windowSClassicItem);
        popupMenu.add(motifItem);

        metalItem.addActionListener(listener);
        nimbusItem.addActionListener(listener);
        windowsItem.addActionListener(listener);
        windowSClassicItem.addActionListener(listener);
        motifItem.addActionListener(listener);

        textArea.setComponentPopupMenu(popupMenu);

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new SwingComponentDemo().init();
    }

    private void changeFlavor(String command) throws Exception {
        switch (command) {
            case "Metal":
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                break;
            case "Nimbus":
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                break;
            case "Windows":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            case "WindowsClassic":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                break;
            case "Motif":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                break;
        }

        // 刷新组件外观
        SwingUtilities.updateComponentTreeUI(f.getContentPane());
        SwingUtilities.updateComponentTreeUI(menuBar);
        SwingUtilities.updateComponentTreeUI(popupMenu);

    }

}
