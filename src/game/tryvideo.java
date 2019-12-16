/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.awt.*;
import javax.swing.*;
import java.io.File;	
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 *
 * @author mahmuod nasr
 */
public class tryvideo extends parent{
    
    
     public static void audio() {
            try {
                File file = new File("2.wav");
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(file));
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            } catch (Exception e) {
                System.err.println("Put the music.wav file in the sound folder if you want to play background music, only optional!");
            }
        }
    
    
  /*  
    public tryvideo() throws IOException{
        // it will play into your own media player
              	Desktop.getDesktop().open(new File("test.mp4"));
    }*/
     private static String arg;
    public static void main(String[] args) throws IOException {
       tryvideo x=new tryvideo();
        arg = "12.gif";
        JFrame f = new JFrame();
        JPanel p = new JPanel();
        JLabel l = new JLabel();
        ImageIcon icon = new ImageIcon(arg);    
        f.setSize(550, 600);
        f.setVisible(true);
        l.setIcon(icon);
        p.add(l);
        f.getContentPane().add(p);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        audio();
    }
    
    
    
}
