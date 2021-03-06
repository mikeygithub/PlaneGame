package game;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @Program: PlaneGame
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-02-14 12:44
 * @Describe：
 **/
public class Plane extends GameObject {
    boolean left;
    boolean up;
    boolean right;
    boolean down;
    boolean live=true;

    public void drawSelf(Graphics graphics){
        if (live){
            graphics.drawImage(image,(int)x,(int)y,null);
            if (left){
                x-=speed;
            }
            if (right){
                x+=speed;
            }
            if (up){
                y-=speed;
            }
            if (down){
                y+=speed;
            }
        }else {

        }
    }

    public Plane(Image image, double x, double y) {

        this.image=image;
        this.x=x;
        this.y=y;
        this.speed=3;
        this.width=image.getWidth(null);
        this.height=image.getHeight(null);
    }

    public void addDirection(KeyEvent keyEvent){
        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left=true;
                break;
           case KeyEvent.VK_RIGHT:
                right=true;
                break;
           case KeyEvent.VK_UP:
                up=true;
                break;
           case KeyEvent.VK_DOWN:
                down=true;
                break;}
    }
    public void minusDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left=false;
                break;
            case KeyEvent.VK_RIGHT:
                right=false;
                break;
            case KeyEvent.VK_UP:
                up=false;
                break;
            case KeyEvent.VK_DOWN:
                down=false;
                break;
        }
        }

}
