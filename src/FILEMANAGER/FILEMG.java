/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FILEMANAGER;

/**
 *
 * @author mahmuod nasr
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import ch8threads.Player;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class FILEMG {

    /*public Player searchPlayer(String username){
     // Player temp=new Player();
     int i;
     for( i=0 ; i<Player.players.size() ; i++){
            
     // temp =Player.players.get(i);
     if(Player.players.get(i).getusername().equals(username))
     return Player.players.get(i);
     //if(temp.getusername().equals(username))
     //  return temp;
     }         
     return Player.players.get(i);               
    
     }
     */
    public Player searchPlayer(String username) {
        for (Player x : Player.players) {
            if (x.getusername().equals(username)) {
                return x;
            }
        }
        return null;

    }
    /*  public Boolean searchPlayer(String username) throws FileNotFoundException, IOException, ClassNotFoundException{
       
     if(Player.users.containsValue(username) )
     return true;
     else
     return false;
     }
     */

    public void save(Player newplayer) throws IOException {
        Player.players.add(newplayer);
        writePlayers();
    }
    
    
    public void modify(Player replace ) throws IOException{
    int place=Player.players.indexOf(replace);
    Player.players.add(place, replace);
    writePlayers();
    }

    public void readloginInfo() throws IOException, ClassNotFoundException {

        File tryx = new File("password.txt");
        if (tryx.exists()) {
            ObjectInputStream loginFile = new ObjectInputStream(new FileInputStream("password.txt"));
            Player.users = (HashMap<String, String>) loginFile.readObject();
            loginFile.close();
        } else {
            ObjectOutputStream loginFile = new ObjectOutputStream(new FileOutputStream("password.txt"));
            loginFile.writeObject(Player.users);
            loginFile.close();

        }

    }

    public void writeloginInfo() throws IOException {

        ObjectOutputStream loginFile = new ObjectOutputStream(new FileOutputStream("password.txt"));
        loginFile.writeObject(Player.users);
        loginFile.close();

    }

    public void readPlayers() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Player> playerss = new ArrayList<>();//palyer object from class player 
        File tryy = new File("game.txt");
        if (tryy.exists()) {
            ObjectInputStream playerArraylist = new ObjectInputStream(new FileInputStream("game.txt"));
            playerss = (ArrayList<Player>) playerArraylist.readObject();
            Player.players = playerss;
            playerArraylist.close();
        }

    }

    public void writePlayers() throws IOException {

        ObjectOutputStream playerArraylist = new ObjectOutputStream(new FileOutputStream("game.txt"));
        playerArraylist.writeObject(Player.players);
        playerArraylist.close();

    }

    public String Rremmeber() {
        String username = null;

        username = Player.users.get("0");

        return username;
    }

    public void Wremmber(String username) {
        try {
            readloginInfo();

            Player.users.put("0", username);
            writeloginInfo();
        } catch (IOException ex) {
            Logger.getLogger(FILEMG.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FILEMG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   

}
