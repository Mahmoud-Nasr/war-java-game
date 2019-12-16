/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch8threads;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.*;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class Ch8Threads extends JFrame {

    /**
     * @param level
     *
     */
    public Ch8Threads(int level) {
        // TODO code application logic here   

       // get screen reslution 
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        setTitle("Saro5");
        setSize(width, height);
        setResizable(false);
        setVisible(true);
        ImageIcon bg;
        bg = new ImageIcon("icon.gif");
        this.setIconImage(bg.getImage());

        MovingBalls mb = new MovingBalls();
        for (int x = 0; x <= level ; x++) {
            Random color = new Random();
            float x1 = color.nextFloat();
            float x2 = color.nextFloat();
            float x3 = color.nextFloat();

            Color random = new Color(x1, x2, x3);
            mb.Balls.add(new Ball(50 * x + 100, 40 * x + 120, 20 + (x % 12) * 5, random));
        }

        add(mb, BorderLayout.CENTER);
        mb.setFocusable(true);
        Thread t1 = new Thread(mb);
        t1.start();
        this.setVisible(false);
        //t1.stop();
        //setDefaultCloseOperation();
        //jf.setVisible(true);

    }

    public static void visability() {
     // this.setVisible(false);

    }

}
