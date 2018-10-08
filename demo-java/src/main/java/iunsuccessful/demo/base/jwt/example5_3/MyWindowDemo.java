package iunsuccessful.demo.base.jwt.example5_3;

import javax.swing.*;
import java.awt.*;

/**
 * Create By LiQZ 2018/9/5
 */
public class MyWindowDemo extends JFrame {

    public MyWindowDemo(String name, JButton button, Color c, int w, int h) {
        super();
        setTitle(name);
        setSize(w, h);
        Container contentPane = getContentPane();
        contentPane.add(button);
        contentPane.setBackground(c);
    }
}
