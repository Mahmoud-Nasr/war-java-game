/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import ch8threads.Ch8Threads;
import ch8threads.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author Mai
 */
public class fram3 extends parent implements ActionListener {

    public ButtonGroup Group;

    public fram3() {

        bg = new ImageIcon("icon.gif");
        this.setIconImage(bg.getImage());
        bg = new ImageIcon("7.jpg");
        l = new JLabel();
        l.setIcon(bg);
        l.setBounds(0, 0, 550, 600);
        this.setLocation((width - 550) / 2 - 100, (height - 500) / 2 - 100);

        this.setLayout(null);

        setSize(550, 600);
        setTitle("Saro5");
        //getContentPane().setBackground(java.awt.Color.decode("#108080"));

        Title = new JLabel("<html><font color='#1b3a14'>Choose Level<font> <html>");
        Title.setFont(new Font("Arial", Font.BOLD, 20));
        Title.setBounds(40, 5, 290, 80);
        this.add(Title);
        Back = new JButton("Back");
        Back.setFont(new Font("Arial", Font.BOLD, 15));
        Back.setBounds(380, 475, 120, 50);
        this.add(Back);
        Follow = new JButton("Start");
        Follow.setFont(new Font("Arial", Font.BOLD, 15));
        Follow.setBounds(380, 400, 120, 50);
        corrent = new JButton("Current");
        corrent.setFont(new Font("Arial", Font.BOLD, 15));
        corrent.setBounds(380, 325, 120, 50);
        this.add(corrent);

        this.add(Follow);
        Follow.addActionListener(this);
        Back.addActionListener(this);
        corrent.addActionListener(this);
        Group = new ButtonGroup();

        String corrent;
        corrent = " Level ";

        for (int i = 0; i < user.level; i++) {

            if (i < 7) {
                lev[i] = new JRadioButton(corrent.concat(Integer.toString(i + 1)));
                lev[i].setBounds(40, 65 + i * 40, 120, 20);
                lev[i].setOpaque(false);

                this.add(lev[i]);
            } else if (i < 12) {

                lev[i] = new JRadioButton(corrent.concat(Integer.toString(i + 1)));
                lev[i].setBounds(40, 65 + i * 40, 120, 20);
                lev[i].setForeground(Color.white);
                lev[i].setOpaque(false);
                this.add(lev[i]);

            } else if (i < 19) {
                lev[i] = new JRadioButton(corrent.concat(Integer.toString(i + 1)));
                lev[i].setBounds(250, 65 + (i % 12) * 40, 120, 20);
                lev[i].setOpaque(false);
                this.add(lev[i]);

            } else if (i < 24) {
                lev[i] = new JRadioButton(corrent.concat(Integer.toString(i + 1)));
                lev[i].setBounds(250, 65 + (i % 12) * 40, 120, 20);
                lev[i].setOpaque(false);
                lev[i].setForeground(Color.white);
                this.add(lev[i]);

            }

            Group.add(lev[i]);
            lev[i].addActionListener(this);
        }

        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.add(l);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Follow) {

            for (int i = 0; i < user.level; i++) {
                if (lev[i].isSelected()) {
                    this.setVisible(false);
                    new Ch8Threads(i).setVisible(true);
                    Player.playinglevel = i + 1;
                }

            }

            /*if (lev[0].isSelected()) {
             //this.setVisible(false);
             new Ch8Threads(user.level).setVisible(true);
             }
             if (lev[1].isSelected()) {
             new Ch8Threads(2).setVisible(true);
             }
             if (lev[2].isSelected()) {
             new Ch8Threads(3).setVisible(true);
             }
             if (lev[3].isSelected()) {
             new Ch8Threads(4).setVisible(true);
             }
             if (lev[4].isSelected()) {
             new Ch8Threads(5).setVisible(true);
             }
             if (lev[5].isSelected()) {
             new Ch8Threads(6).setVisible(true);
             }
             if (lev[6].isSelected()) {
             new Ch8Threads(7).setVisible(true);
             }
             if (lev[7].isSelected()) {
             new Ch8Threads(8).setVisible(true);
             }
             if (lev[8].isSelected()) {
             new Ch8Threads(9).setVisible(true);
             }
             if (lev[9].isSelected()) {
             new Ch8Threads(10).setVisible(true);
             }
             if (lev[10].isSelected()) {
             new Ch8Threads(11).setVisible(true);
             }
             if (lev[11].isSelected()) {
             new Ch8Threads(12).setVisible(true);
             }
             if (lev[12].isSelected()) {
             new Ch8Threads(13).setVisible(true);
             }
             if (lev[13].isSelected()) {
             new Ch8Threads(14).setVisible(true);
             }
             if (lev[14].isSelected()) {
             new Ch8Threads(15).setVisible(true);
             }
             if (lev[15].isSelected()) {
             new ch8threads.Ch8Threads(16).setVisible(true);
             }
             if (lev[16].isSelected()) {
             new ch8threads.Ch8Threads(17).setVisible(true);
             }
             if (lev[17].isSelected()) {
             new ch8threads.Ch8Threads(18).setVisible(true);
             }
             if (lev[18].isSelected()) {
             new ch8threads.Ch8Threads(19).setVisible(true);
             }
             if (lev[19].isSelected()) {
             new ch8threads.Ch8Threads(20).setVisible(true);
             }
             if (lev[20].isSelected()) {
             new ch8threads.Ch8Threads(21).setVisible(true);
             }
             if (lev[21].isSelected()) {
             new ch8threads.Ch8Threads(22).setVisible(true);
             }
             if (lev[22].isSelected()) {
             new ch8threads.Ch8Threads(23).setVisible(true);
             }
             if (lev[23].isSelected()) {
             new ch8threads.Ch8Threads(24).setVisible(true);
             } */
        }

        if (e.getSource() == corrent) {
            user.playinglevel = user.level;
            new Ch8Threads(user.level).setVisible(true);

        }

        if (e.getSource() == Back) {
            this.setVisible(false);
            new fram2().setVisible(true);
        }
    }
}
