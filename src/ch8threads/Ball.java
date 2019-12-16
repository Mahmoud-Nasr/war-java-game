/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;

/**
 *
 * @author mahmoud
 */
public class Ball {
     public int x,y,w=70,h=80;
    public int speedx;
    public Color CurrentColor;
    public Ball(int x,int y,int speedx,Color color)
    {
        
        this.x=x;
        this.y=y;
        this.speedx=speedx;
        this.CurrentColor=color;
        
        
    }
    public Ball()
    {
        x=10;
        y=140;
        speedx = 10;
        CurrentColor = Color.GREEN;
        
    }
    synchronized public  void move(int width)
    {
        x+=speedx;
        if (x+90>width)
        {
         //   speedx= -speedx;
            x=-100;
        }
        if (x<0)
        {
           // speedx= -speedx;
        }
    }
    
}
