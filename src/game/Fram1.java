/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import FILEMANAGER.FILEMG;
import FILEMANAGER.Music;
import com.sun.swing.internal.plaf.metal.resources.metal;
import static game.tryvideo.audio;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

/**
 *
 * @author Mai
 */
public class Fram1 extends parent implements ActionListener {

    
    JCheckBox ch;
    JTextField usernam;
    JPasswordField passwor;
   
    
    
    

    public Fram1() throws IOException, FileNotFoundException, ClassNotFoundException  {
        
        
       
       song.musicStart();
         
        
        // intial game data
        input.readPlayers();
        input.readloginInfo();
        
        this.setLocation((width-550)/2-100,(height-500)/2-100);
        bg = new ImageIcon("icon.gif");
        this.setIconImage(bg.getImage());
        //this.setIconImage(new ImageIcon("rocketMenna.gif"));
        bg = new ImageIcon("4.jpg");
        l = new JLabel();
        l.setIcon(bg);
        l.setBounds(0, 0, 550   , 600);
        
        
        
        
        
        this.setLayout(null);

        this.setSize(550,600);
        setTitle("Saro5");
        //getContentPane().setBackground(java.awt.Color.decode("#108080"));

        Title = new JLabel("<html><font Color=' #1b3a14'>Sign In</font></html>");
        Title.setFont(new Font("Arial", Font.BOLD, 20));
        Title.setBounds(230, 10, 290, 80);
        this.add(Title);
        Title = new JLabel("<html><font Color=' #1b3a14'>Use Your Game account</font></html>");
        Title.setFont(new Font("Arial", Font.BOLD, 20));
        Title.setBounds(155, 40, 290, 80);
        this.add(Title);
        username = new JLabel("<html><font Color='white'>User</font>"+"<font Color='white'>name</font></html>");
        passWord = new JLabel("<html><font Color='white'>Password</font></html>");

        username.setBounds(80, 100, 120, 30);
        passWord.setBounds(80, 170, 120, 30);
        this.add(username);
        this.add(passWord);
        usertext = new JTextField(input.Rremmeber());
        //JTextField menna= new HintTextField("here test");
        pass = new JPasswordField();
        usertext.setBounds(80, 130, 190, 30);
        pass.setBounds(80, 200, 190, 30);
        this.add(usertext);
        this.add(pass);
        formail = new JButton();
        formail.setText("<html>  <font Color=' #1b3a14'> Forget Username? </font> </html>");
        //formail.setBackground(java.awt.Color.decode("#108080"));
        formail.setBounds(290, 130, 160, 30);
        this.add(formail);
        forpass = new JButton();
        forpass.setText("<html>   <font Color=' #1b3a14'>Forget Password? </font> </html>");

        forpass.setBounds(290, 200, 160, 30);
        //forpass.setBackground(java.awt.Color.decode("#108080"));
        this.add(forpass);
        ch = new JCheckBox();
        ch.setBounds(80, 240, 20, 20);
        ch.setOpaque(false);
        this.add(ch);
        
        
        remember = new JLabel("<html> <font Color='#1b3a14'> Remember Me </font></html>");
        
        remember.setBounds(110, 235, 120, 30);
        this.add(remember);

        
        login = new JButton("<html><font Color='#1b3a14'>Log In </font> </html>");
        login.setFont(new Font("Arial", Font.BOLD, 19));
        login.setBounds(180, 300, 160, 50);
        
        this.add(login);
        create = new JLabel("<html> <font Color='#1b3a14'> Create New Account  </font></html>");
        create.setFont(new Font("Arial", Font.BOLD, 20));
        //create.setFont(new Font("Arial", Font.BOLD, 15));
        create.setBounds(170, 355, 270, 50);
        this.add(create);
        signup = new JButton("<html> <font Color='#1b3a14'> Sign Up  </font></html>");
        
        signup.setFont(new Font("Arial", Font.BOLD, 19));
        signup.setBounds(180, 410, 160, 50);
        this.add(signup);
        mute = new JCheckBox();
        mute.setBounds(40, 500, 20, 20);
        
       // mute.setOpaque(false);
        this.add(mute);
        remember = new JLabel("<html> <font Color='#ffffff'> Mute </font></html>");
        remember.setFont(new Font("Arial", Font.BOLD, 15));
        remember.setBounds(70, 495, 120, 30);
        this.add(remember);

        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        login.addActionListener(this);
        signup.addActionListener(this);
        ch.addActionListener(this);
        usertext.addActionListener(this);
        formail.addActionListener(this);
        forpass.addActionListener(this);
        mute.addActionListener(this);
        this.add(l);
    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        
        if (e.getSource() == login) {
            if (ch.isSelected()) {
                
                
                input.Wremmber( usertext.getText() );
           
            
            }
            
            
            
            user.setusername(usertext.getText());
            user.setpassword(pass.getText());
            
            try {
                if(pass.getText().isEmpty() || usertext.getText().isEmpty())
                JOptionPane.showMessageDialog(rootPane, "Please Enter Your Password /User Name", "Empty slots", JOptionPane.WARNING_MESSAGE);
                else if( user.Login() )
                {
                this.setVisible(false);
                user=input.searchPlayer(usertext.getText());
                new fram2().setVisible(true);
                }else
                {
                JOptionPane.showMessageDialog(rootPane, "You Entered wrong UserName / Password" ,"Wrong Information",JOptionPane.ERROR_MESSAGE);
                
                }
                    
                    
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Fram1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Fram1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if (e.getSource() == signup) {
            
                
            this.setVisible(false);
            new fram4().setVisible(true);
        }else if(e.getSource()== formail ){
            this.setVisible(false);
        new fram5().setVisible(true);
         } else if (e.getSource()== forpass){
             this.setVisible(false);
        new fram6().setVisible(true);
        }
       
        if(mute.isSelected()){
            song.mute();
            
         
         
                }
        else {
            
            song.musicStart();
        }}

}
