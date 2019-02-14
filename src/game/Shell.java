package game;

import java.awt.*;

/**
 * @Program: PlaneGame
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-02-14 12:59
 * @Describe：
 **/
public class Shell extends GameObject{

    double degree;

    public Shell() {
        x=200;
        y=200;
        width=10;
        height=10;
        speed=3;
        degree = Math.random()*Math.PI*2;
    }

    public void draw(Graphics graphics){
        Color color=graphics.getColor();
        graphics.setColor(Color.YELLOW);

        graphics.fillOval((int)x,(int)y,width,height);

        x+=speed*Math.cos(degree);
        y+=speed*Math.sin(degree);

        if (x<0||x>Constant.GAME_WIDTH-width){
            degree=Math.PI-degree;
        }
        if (y<0||y>Constant.GAME_HEIGHT-height){
            degree=-degree;
        }
        graphics.setColor(color);
    }
}
