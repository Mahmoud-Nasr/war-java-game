/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FILEMANAGER;

import ch8threads.Player;

/**
 *
 * @author boody 2
 */
public class MennaExcepctions {

    public Boolean emailValid(String email) {

        if (email.endsWith("@yahoo.com") || email.endsWith("@gmail.com") || email.endsWith("@hotmail.com") || email.endsWith("@outlook.com") || email.endsWith("@ymail.com")) {
            return true;
        }

        return false;

    }

    public Boolean phoneValid(String phone) {
        // int phoneNumber = 0;
        if (phone.length() == 11 && (phone.matches("[0-9]+"))) {

            //   phoneNumber = Integer.parseInt(phone);
            return true;
        }
        return false;

    }

    public Boolean CheckUsername(String username) {
        if (Player.users.containsValue(username)) {
            return false;
        } else {
            return true;
        }
    }
    /*
     public Boolean CheckEmail(String emails) {
     int i;
     Player temp = new Player();
     for (i = 0; i < Player.players.size(); i++) {
     temp = Player.players.get(i);
     if (temp.email.equals(emails)) {
     return false;
     }

     }
     return true;

     }
    
     */
    /*public Boolean CheckPhone(String phone){
    
     int i;
     Player temp = new Player();
     for (i = 0; i < Player.players.size(); i++) {
     temp = Player.players.get(i);
     if (temp..equals(phone)) {
     return false;
     }

     }
     return true;

     }
     */

    public Boolean CheckEmail(String emails) {
        // int phonenumber = Integer.parseInt(phones);
        for (Player x : Player.players) {
            if (x.email.equals(emails)) {

                return false;
            }
        }
        return true;

    }

    public Boolean CheckPhone(String phones) {
        int phonenumber = Integer.parseInt(phones);
        for (Player x : Player.players) {
            if (x.phone == phonenumber) {

                return false;
            }
        }
        return true;

    }
}
