/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author ASUS
 */
    public class Bullet implements Runnable{
    public Point pos=new Point();
    public Color CurrentColor;
    public int Speed;
    public String imgPath;
    public Bullet()
    {
        Speed=4;
        pos.y=-100;
        
    }
    synchronized public  void  move()
    {
        if( pos.y >= -200 )
            pos.y-=Speed;
        
        
    }

    @Override
    public void run() {
        for (int i=0;i<400;i++)
        {
            //System.out.println("Rocket Moving " +pos.y);
            move();
            try {
                Thread.sleep(4);
            } catch (InterruptedException ex) {
                
            }
            
        }
    }
}
