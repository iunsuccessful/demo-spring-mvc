package iunsuccessful.demo.base.jwt.example5_3;

import iunsuccessful.demo.base.jwt.example5_2.MyWindowDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

/**
 * Create By LiQZ 2018/9/5
 */
public class Example5_3 {

    public static void main(String[] args) {

        JFrame mw = new JFrame("JFrame Test");
        mw.setSize(250, 200);
        Container conPane = mw.getContentPane();
        conPane.setBackground(Color.red);
        conPane.setLayout(new FlowLayout());
        JButton button5_3 = new JButton();
        button5_3.setText("click me!");
        button5_3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conPane.setBackground(Color.blue);
            }
        });
        conPane.add(button5_3);

        mw.setVisible(true);
    }

}
