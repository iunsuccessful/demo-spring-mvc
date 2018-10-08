package iunsuccessful.demo.base.jwt.graphics;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Create By LiQZ 2018/9/5
 */
public class GraphicsDemo {

    public static void main(String[] args) {

    }

    public static void paintComponet(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.red);
        Rectangle2D rec = new Rectangle2D.Double(10, 30, 50, 50);
        g2d.draw(rec);
    }

}
