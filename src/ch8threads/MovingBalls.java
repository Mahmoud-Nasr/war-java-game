/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch8threads;

import game.fram3;
import game.fram7;
import game.parent;
import static game.parent.user;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class MovingBalls extends JPanel implements Runnable {

    JFrame frame;
    Timer time;
    int hitscore = 0;

    public ArrayList<Ball> Balls = new ArrayList<Ball>(5);
    public Tank BlueTank = new Tank("plane3.gif");
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
    //ImageIcon bg = new ImageIcon("7.jpg");
    //  JLabel l = new JLabel();

    public MovingBalls() {

        time = new Timer();
        BlueTank.pos.setLocation(width / 2 - 50, height - 240);
        this.addKeyListener(new keylist());

    }

    private class keylist implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

                BlueTank.mover();

            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {

                BlueTank.movel();

            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (BlueTank.Rocket.pos.y <= 0) {
                    BlueTank.fireBullet();
                }

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    synchronized public void paintComponent(Graphics g) {
        BufferedImage ball = null;

        g.clearRect(0, 0, 1920, 1080);

        try {
            BufferedImage imgtank = ImageIO.read(new File(BlueTank.ImagePath));
            BufferedImage imgrocket = ImageIO.read(new File(BlueTank.Rocket.imgPath));
            BufferedImage imgrocket1 = ImageIO.read(new File("rocketImage.gif"));

            StringBuilder sb = new StringBuilder();
            Formatter formatter = new Formatter(sb);

            formatter.format(Timer.STime);

            g.drawString(sb.toString().toUpperCase(), 80, 30);
            StringBuilder score = new StringBuilder();
            Formatter forscore = new Formatter(score);
            forscore.format("Score:  " + hitscore);

            g.drawString(score.toString().toUpperCase(), 200, 30);
            g.drawImage(imgtank, BlueTank.pos.x, BlueTank.pos.y, null);
            g.drawImage(imgrocket, BlueTank.Rocket.pos.x + 5, BlueTank.Rocket.pos.y, null);
            g.drawImage(imgrocket1, 30, 0, null);

            //g.drawImage(imgrocket2, 0, 0, null);
        } catch (IOException e) {
            System.out.println(e);
        }

        for (Ball OneBall : Balls) {
            try {
                ball = ImageIO.read(new File("ball.gif"));
            } catch (IOException ex) {
                Logger.getLogger(MovingBalls.class.getName()).log(Level.SEVERE, null, ex);
            }
            g.drawImage(ball, OneBall.x, OneBall.y, OneBall.w * 2, OneBall.h, null);
            //g.fillOval(OneBall.x, OneBall.y, OneBall.w, OneBall.h);
            if (BlueTank.Rocket.pos.distance(OneBall.x, OneBall.y) <= 90) {
                try {

                    Balls.remove(OneBall);
                    hitscore++;
                    if (Balls.isEmpty()) {
                        time.end();
                           frame = (JFrame) SwingUtilities.getRoot(this);
                        if (user.level == Player.playinglevel) {

                            user.level++;
                            user.HighScore += hitscore;
                            user.levelscore =hitscore;
                            parent.input.modify(user);
                            frame.setVisible(false);
                            new fram7().setVisible(true);
                        }
                        else 
                        {
                            
                            user.HighScore += hitscore;
                            user.levelscore =hitscore;
                            parent.input.modify(user);
                            frame.setVisible(false);
                            new fram7().setVisible(true); 
                        }
                        //frame = (JFrame) SwingUtilities.getRoot(this);
                        //frame.setVisible(false);

                        // new fram3().setVisible(true);
                        // new fram7().setVisible(true);

                    }
                    Thread.sleep(200);
                    break;
                } catch (InterruptedException ex) {
                    Logger.getLogger(MovingBalls.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MovingBalls.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }

    @Override
    public void run() {
        try {
            time.start();
            while (true) {
                for (Ball OneBall : Balls) {
                    OneBall.move(this.getWidth());
                    if (time.end) {
                        time.end();
                        frame = (JFrame) SwingUtilities.getRoot(this);
                        //this.setVisible(false);
                        frame.setVisible(false);
                        JOptionPane.showMessageDialog(this, "Time End");
                        new fram3().setVisible(true);
                        
                        Thread.currentThread().stop();
                    }
                }

                //y+=10;
                Thread.sleep(50);
                repaint();
            }
        } catch (InterruptedException e) {
        }
    }

}
