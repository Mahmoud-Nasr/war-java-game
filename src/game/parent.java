/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import ch8threads.*;
import FILEMANAGER.FILEMG;
import FILEMANAGER.MennaExcepctions;
import FILEMANAGER.Music;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

/**
 *
 * @author Mai
 */
public class parent extends JFrame {

    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
    
    //fram1
    public JLabel Title, username, passWord, remember, create;
    public JButton formail, forpass, login, signup;
    //fram2
    public JLabel chatWith;
    public JButton playNow, Chatting, logout, option;
    public JRadioButton chatSupport, chatPlayer;
    //fram3
    public JRadioButton  lev []=new JRadioButton[24];
    public JButton Back, Follow,corrent;

    ////fram4
    public JLabel title, userNAME, PASSword, Repeate, otherMail, CountryY, Telephone;
    public JTextField usertext, email, phone;
    public JPasswordField pass, repass;
    ///fram5
    public JLabel Tit, MAdrees, YourPass;
    //fram6
    public JLabel adrees, usname, numberPhone;
    public JTextField USER, NUMBER;
    
     public JCheckBox mute; 

    public static Player user = new Player();
    public static FILEMG input = new FILEMG();
    MennaExcepctions kmf=new MennaExcepctions();
    ImageIcon bg;
    JLabel l;
    public static Music song=new Music();

}
