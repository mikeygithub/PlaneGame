package game;

import java.awt.*;

/**
 * @Program: PlaneGame
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-02-14 13:08
 * @Describe：
 **/
public class Explode {
    double x;
    double y;
    static Image[] images=new Image[16];
    static {
        for (int i=0;i<16;i++){
            images[i]=GameUtil.getImage("images/explode/e"+(i+1)+".gif");
            images[i].getWidth(null);
        }
    }

    int count;

    public void draw(Graphics graphics){
        if (count<=15){
            graphics.drawImage(images[count],(int)x,(int)y,null);
            count++;
        }
    }
    public Explode(double x,double y){
        this.x=x;
        this.y=y;
    }
}
