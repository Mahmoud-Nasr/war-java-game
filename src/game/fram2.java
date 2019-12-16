/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import FILEMANAGER.Music;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

/**
 *
 * @author Mai
 */
public class fram2 extends parent implements ActionListener{
    
    
     
    public fram2()
    {
        
        bg = new ImageIcon("icon.gif");
        this.setIconImage(bg.getImage());
        bg = new ImageIcon("7.jpg");
        l = new JLabel();
        l.setIcon(bg);
        l.setBounds(0, 0, 550   , 600);
        
        this.setLayout(null);
        setSize( 550,600 );
        setTitle("Saro5");
        //getContentPane().setBackground(java.awt.Color.decode("#108080"));
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation((width-550)/2-100,(height-500)/2-100);
         playNow=new JButton("Play Now!");
         playNow.setFont(new Font("Arial", Font.PLAIN, 20));
        playNow.setBounds(180, 60, 200, 60); 
        this.add(playNow);
        
        Chatting=new JButton("Chatting");
        Chatting.setFont(new Font("Arial", Font.PLAIN, 20));
        Chatting.setBounds(180, 180, 200, 60); 
        this.add(Chatting);
         /*JCheckBox h=new JCheckBox();
       h.setBounds(130, 255, 20, 20);
       this.add(h);
         */
        chatPlayer=new JRadioButton(" Chat With Player ");
        chatPlayer.setOpaque(false);
       chatPlayer.setFont(new Font("Arial", Font.BOLD, 15));
       chatPlayer.setBounds(195, 250, 170, 30);
       this.add(chatPlayer);
        /*JCheckBox B=new JCheckBox();
       B.setBounds(130, 290, 20, 20);
       this.add(B);*/
       chatSupport=new JRadioButton("Chat With Support");
       chatSupport.setOpaque(false);
       chatSupport.setFont(new Font("Arial", Font.BOLD, 15));
       //chatSupport.setBackground(traspaernt);
       chatSupport.setBounds(195, 285, 170, 30);
       this.add(chatSupport);
       ButtonGroup group=new ButtonGroup();
       group.add(chatPlayer);
       group.add(chatSupport);
        option=new JButton("Help");
        option.setFont(new Font("Arial", Font.PLAIN, 20));
        option.setBounds(180, 340, 200, 60); 
        this.add(option);
       
        
         logout=new JButton("Log Out");
         logout.setFont(new Font("Arial", Font.PLAIN, 20));
        logout.setBounds(180, 460, 200, 60); 
        this.add(logout);
       playNow.addActionListener(this);
       Chatting.addActionListener(this);
       option.addActionListener(this);
       logout.addActionListener(this);
       this.add(l);
    
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==playNow)
        {
            this.setVisible(false );
         new fram3().setVisible(true);
        
        }
        
        if(e.getSource()== logout)
        {
            try {
                this.setVisible(false);
                
               song.mute();
                new Fram1().setVisible(true);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(fram2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        
    }
    
    
    
}

