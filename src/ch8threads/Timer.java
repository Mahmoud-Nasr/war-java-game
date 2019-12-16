/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch8threads;

import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Ahmed
 */
public class Timer extends JFrame {

    JLabel time;
    java.util.Timer timer = new java.util.Timer();
    TimerTask TT;
    public static String STime = "";
    public static int sec = 10;
    public static Boolean end = false;
    /* public static void main(String[] args) {
     Timer time = new Timer();
     time.start();
       
     }*/

    public Timer() {

        time = new JLabel("Get Ready");
        time.setBounds(80, 100, 100, 40);
        this.add(time);
        TT = new TimerTask() {

            @Override
            public void run() {
                if (!end) {
                    sec--;
                    if (sec <= 9 && sec >= 0) {
                        STime = ("Timer:  00:00:0" + sec);
                    } else if (sec <= 0) {
                        end = true;

                    } else {
                        STime = ("Timer:  00:00:" + sec);
                    }
                }

            }
        };

    }

    public void start() {
        this.end = false;
        timer.scheduleAtFixedRate(TT, 200, 1000);

    }

    public void end() {
        timer.cancel();
        this.end = true;
        this.sec = 10;

    }

}
