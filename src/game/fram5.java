/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import ch8threads.Player;
import static ch8threads.Player.players;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;


/**
 *
 * @author Mai
 */
public class fram5 extends parent implements ActionListener {

    public JTextField Email;
    public JPasswordField passworD;
    public JButton Confrm;

    public fram5() {
        bg = new ImageIcon("icon.gif");
        this.setIconImage(bg.getImage());
        bg = new ImageIcon("7.jpg");
        l = new JLabel();
        l.setIcon(bg);
        l.setSize(450, 240);
        setResizable(false);
        this.setLocation((width-550)/2-100,(height-500)/2-100);
        setSize(450, 240);
        setTitle("Saro5");

        MAdrees = new JLabel("<html><font Color='#1b3a14'>  Email Address </font></html>");
        MAdrees.setFont(new Font("Arial", Font.BOLD, 20));
        MAdrees.setBounds(70, 30, 170, 30);
        this.add(MAdrees);

        Email = new JTextField();
        Email.setBounds(70, 60, 300, 25);
        this.add(Email);

        Confrm = new JButton("Show Username");
        Confrm.setFont(new Font("Arial", Font.BOLD, 15));
        Confrm.setBounds(190, 120, 170, 60);
        this.add(Confrm);
        
        Back=new JButton("Back");
        Back.setFont(new Font("Arial", Font.BOLD, 15));
        Back.setBounds( 80 , 120 , 100 , 60);
        
        this.add(Back);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        add(l);
        
        Confrm.addActionListener(this);
        Back.addActionListener(this);
        
        
    }

    

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Confrm)
        {
            String test=Email.getText();
          if( ! kmf.CheckEmail(test) )
          {
           for(Player x:players)
           { 
               if ( x.email.equals(test))
               {
               JOptionPane.showMessageDialog(rootPane, ""+x.getusername());
               
               }
           
           
           }
          
          }else
        {
         JOptionPane.showMessageDialog(rootPane, "Your Email Not Found");
        
        }
        
        
        
        }
        else if(e.getSource() == Back){
            try {
                this.setVisible(false);
                new Fram1().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(fram6.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(fram6.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }

}
