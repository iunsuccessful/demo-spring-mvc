package iunsuccessful.demo.base.jwt.example5_2;

import javax.swing.*;
import java.awt.*;

/**
 * Create By LiQZ 2018/9/5
 */
public class Example5_2 {

    public static MyWindowDemo mw1;
    public static MyWindowDemo mw2;

    public static void main(String[] args) {
        JButton button1 = new JButton("first button");
        String name1 = "first windows";
        String name2 = "second windows";
        mw1 = new MyWindowDemo(name1, button1, Color.blue, 350, 450);
        mw1.setVisible(true);
        JButton button2 = new JButton("second button");
        mw2 = new MyWindowDemo(name2, button2, Color.magenta, 300, 400);
        mw2.setVisible(true);

    }


}
