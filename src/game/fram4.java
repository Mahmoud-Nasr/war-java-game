/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import ch8threads.Player;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Mai
 */
public class fram4 extends parent implements ActionListener {

    public JButton Aa;
    public JComboBox country;
    HashMap<String, String> xs = new HashMap<>();

    
    
    
    public fram4() {

        
        
        bg = new ImageIcon("icon.gif");
        this.setIconImage(bg.getImage());
        bg = new ImageIcon("7.jpg");
        l = new JLabel();
        l.setIcon(bg);
        l.setBounds(0, 0, 550   , 600);
        this.setLocation((width-550)/2-100,(height-500)/2-100);
        
        
        this.setLayout(null);

        setSize(550, 600);
        setTitle("Saro5");
        // getContentPane().setBackground(java.awt.Color.decode("#108080"));

        title = new JLabel("Sign Up Information");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(180, 40, 290, 80);
        this.add(title);
        userNAME = new JLabel("Username");
        userNAME.setFont(new Font("Arial", Font.BOLD, 15));
        PASSword = new JLabel("password");
        PASSword.setFont(new Font("Arial", Font.BOLD, 15));
        Repeate = new JLabel("Repeat Password");
        Repeate.setFont(new Font("Arial", Font.BOLD, 15));
        otherMail = new JLabel("<html><font color='white'>Email Address</font></html>");
        otherMail.setFont(new Font("Arial", Font.BOLD, 15));
        CountryY = new JLabel("<html><font color='white'>Your Country</font></html>");

        CountryY.setFont(new Font("Arial", Font.BOLD, 15));
        Telephone = new JLabel("<html><font color='white'>Phone Number</font></html>");
        Telephone.setFont(new Font("Arial", Font.BOLD, 15));
        userNAME.setBounds(60, 120, 140, 30);
        PASSword.setBounds(60, 190, 140, 30);
        Repeate.setBounds(60, 260, 140, 30);
        otherMail.setBounds(60, 330, 140, 30);
        CountryY.setBounds(60, 400, 140, 30);
        Telephone.setBounds(60, 470, 140, 30);
        this.add(userNAME);
        this.add(PASSword);
        this.add(Repeate);
        this.add(otherMail);
        this.add(CountryY);
        this.add(Telephone);

        usertext = new JTextField();

        //mail.setText("enter some things");
        pass = new JPasswordField();
        repass = new JPasswordField();
        email = new JTextField();
        //country=new JTextField();
        String[] Countres = {"England", "German", "Japan", "China", "United State", "Russia", "Australia", "Egypt"};
        country = new JComboBox( Countres );
        country.setSelectedIndex(7);
        phone = new JTextField();
        usertext.setBounds(60, 150, 230, 25);
        pass.setBounds(60, 220, 230, 25);
        repass.setBounds(60, 290, 230, 25);
        email.setBounds(60, 360, 230, 25);
        country.setBounds(60, 430, 230, 25);
        phone.setBounds(60, 500, 230, 25);

        this.add(usertext);
        this.add(pass);
        this.add(repass);
        this.add(email);
        this.add(country);
        this.add(phone);

        Aa = new JButton("Confirm");
        Aa.setFont(new Font("Arial", Font.BOLD, 15));
        Aa.setBounds(370, 400, 120, 50);
        this.add(Aa);
        Back=new JButton("Back");
        Back.setFont(new Font("Arial", Font.BOLD, 15));
        Back.setBounds(370, 475, 120, 50);
        this.add(Back);
        Back.addActionListener(this);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);

        Aa.addActionListener(this);
        add(l);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Aa) {
            if(usertext.getText().isEmpty() || pass.getText().isEmpty() || email.getText().isEmpty() || phone.getText().isEmpty() || repass.getText().isEmpty() )
            {
            JOptionPane.showMessageDialog(rootPane, "You Have An Empty Slot");
            }
            
            else if (kmf.CheckUsername(usertext.getText())) {
                user.setusername(usertext.getText());
                if (pass.getText().equals(repass.getText())) {
                    try {

                        user.setpassword(pass.getText());
                        String emailing =email.getText();
                        if (kmf.emailValid(emailing) ) {
                                if(kmf.CheckEmail(emailing)){
                                     user.email = emailing;
                                
                                
                                user.city = country.getActionCommand();
                            if (kmf.phoneValid(phone.getText())) {
                                
                                if(kmf.CheckPhone(phone.getText())){
                                user.phone = Integer.parseInt(phone.getText());
                                
                                Player.players.add(user);
                                Player.users.put(user.getusername(), user.getpassword());
                                input.writePlayers();
                                input.writeloginInfo();
                                JOptionPane.showMessageDialog(null, "Successfully Signed New Account", "Welcome in Our Game", JOptionPane.INFORMATION_MESSAGE);
                                this.setVisible(false);
                                new Fram1().setVisible(true);
                                
                                
                                
                                
                                
                                }else
                                    JOptionPane.showMessageDialog(null, "This phone No. is used before", "Error", JOptionPane.ERROR_MESSAGE);
                               
                                    

                                
                                
                                
                                
                                
                                }else
                                    JOptionPane.showMessageDialog(null, "This phone is Valid", "Error", JOptionPane.ERROR_MESSAGE);
                               
                               
                            

                            } else 
                            {
                                JOptionPane.showMessageDialog(null, "Invalid Phone Number", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid E-mail", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(fram4.class.getName()).log(Level.SEVERE, null, ex);

                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(fram4.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not Matching Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else//username
            {
                JOptionPane.showMessageDialog(null, "This usename is used before", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }else if( e.getSource() == Back )
        {
            
            try {
                this.setVisible(false);
                new Fram1().setVisible(true);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(fram4.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }

    }
  
}
