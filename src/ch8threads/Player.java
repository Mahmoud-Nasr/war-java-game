/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch8threads;
import java.util.*;
import FILEMANAGER.FILEMG;
import java.io.*;
/**
 *
 * @author Ahmed
 */
public class Player implements Serializable{
    public static ArrayList<Player> players = new ArrayList<>();
    public static HashMap<String,String> users=new HashMap<>();
    
    
    private String username;
    private String password;
    public int level;
    public static int playinglevel;
    public int HighScore;
    public String city ;
    public String email ;
    public int phone;
   public int levelscore;
    
    
    public Player(){
    level=1;
    HighScore=0;
    
    
    }
    
    
    
    public void setusername(String username)
    {
        this.username=username;
    }
    public String getusername()
    {
        return this.username;
    }
    public void setpassword(String password)
    {
        this.password = password;
    }
    public String getpassword()
    {
        return this.password;
    }
    public Boolean Login () throws ClassNotFoundException , IOException 
    {
        FILEMG art=new FILEMG();
        art.readloginInfo();
        if( users.containsKey(getusername() ) )
        {
        if ( password.equals(users.get(getusername() ) ) )
        {
            return true;
        }
        }
       
            return false;
    }
    
}
