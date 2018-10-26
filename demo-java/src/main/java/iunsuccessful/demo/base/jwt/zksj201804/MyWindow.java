package iunsuccessful.demo.base.jwt.zksj201804;

import iunsuccessful.demo.common.utils.PrintUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Create By LiQZ 2018/10/19
 */
class MyWindowDemo extends JFrame implements ItemListener {

    JTextArea text;
    JCheckBox[] box;
    String boxName[] = {"张三", "李四", "王五"};

    public MyWindowDemo(String title) throws HeadlessException {
        super(title);
        Container con = this.getContentPane();
        con.setLayout(new GridLayout(1, 2));
        setLocation(100, 100);
        JPanel panel = new JPanel();
        int len = boxName.length;
        panel.setLayout(new GridLayout(len, 1));
        box = new JCheckBox[len];
        for (int i = 0; i < len; i++) {
            box[i] = new JCheckBox(boxName[i], false);
            box[i].addItemListener(this);
            panel.add(box[i]);
        }
        con.add(panel);
        text = new JTextArea(4, 10);
        con.add(text);
        setVisible(true);
        pack(); // what's means?
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        text.setText(null);
        for (int i = 0; i < box.length; i++) {
            if (box[i].isSelected()) {
                text.append(boxName[i]);
                text.append("被选中\n");
            }
        }
    }


}

public class MyWindow {

    public static void main(String[] args) {
//        new MyWindowDemo("试题33");
        int[] a = {1,2,3,4,5};
        PrintUtils.print(invertArray(a));
    }

    static int[] invertArray(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[a.length - i - 1] = a[i];
        }
        return b;
    }

}
