/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import ch8threads.Ch8Threads;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author mahmuod nasr
 */
public class fram7 extends parent implements ActionListener {

    public static void main(String[] args) {
        fram7 x = new fram7();
        x.setVisible(true);
    }

    public fram7() {

        setTitle("Saro5");
        bg = new ImageIcon("icon.gif");
        this.setIconImage(bg.getImage());
        bg = new ImageIcon("7.jpg");

        l = new JLabel();
        l.setIcon(bg);
        l.setSize(550, 600);
        setResizable(false);
        this.setLocation((width - 550) / 2 - 100, (height - 500) / 2 - 100);
        setSize(550, 600);
        Follow = new JButton("Next Level");
        Follow.setFont(new Font("Arial", Font.BOLD, 15));
        Follow.setBounds(290, 410, 150, 50);
        Back = new JButton("Back");
        Back.setFont(new Font("Arial", Font.BOLD, 15));
        Back.setBounds(110, 410, 150, 50);
        title = new JLabel("<html> <font Color='#334829'>Congratulations Level " + user.playinglevel + " Completed </font></html>");

        // title.setBackground(Color.yellow);
        // title.setForeground(Color.decode("#454545"));
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(120, 70, 500, 50);

        JLabel username = new JLabel("Username: " + user.getusername());
        username.setBounds(160, 220, 500, 50);
        username.setFont(new Font("Arial", Font.BOLD, 16));

        add(username);
        JLabel yourScore = new JLabel("Level Score : " + user.levelscore+" point");
        JLabel totalScore = new JLabel("Highest Score : " + user.HighScore +" point");
        yourScore.setBounds(160, 260, 500, 50);
        yourScore.setFont(new Font("Arial", Font.BOLD, 16));
        totalScore.setFont(new Font("Arial", Font.BOLD, 16));
        add(yourScore);
        totalScore.setBounds(160, 300, 500, 50);
        add(totalScore);

        add(title);
        add(Follow);
        add(Back);
        add(l);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Follow.addActionListener(this);
        Back.addActionListener(this);

    }

    /*public static void main(String[] args) {
     fram7 x=new fram7();
     x.setVisible(true);
     }*/
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Follow) {
            this.setVisible(false);
            new ch8threads.Ch8Threads(user.playinglevel++).setVisible(true);

        } else {
            this.setVisible(false);
            new fram2().setVisible(true);

        }
    }

}
