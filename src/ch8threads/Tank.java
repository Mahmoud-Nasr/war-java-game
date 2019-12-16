/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

/**
 *
 * @author ASUS
 */
public class Tank {
    public Point pos=new Point();
    public String ImagePath;
    public Bullet Rocket = new Bullet();
    public Bullet Rocketpro = new Bullet();
    public int speed;
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();
    
    public Tank (String ImagePath)
    {
        speed=30;
        this.ImagePath=ImagePath;
        Rocket.imgPath="rocketMenna2.gif";
        
    }

    synchronized void mover() {
        if(this.pos.x<width-200 )
            this.pos.x+=speed;
    }
    
    synchronized void movel() {
          if(this.pos.x>0)
               this.pos.x-=speed;
    }

    public void fireBullet() {
        Rocket.pos.x=this.pos.x+60;
        Rocket.pos.y=this.pos.y;
        Thread t1=new Thread (Rocket);
        t1.start();
    }
}
