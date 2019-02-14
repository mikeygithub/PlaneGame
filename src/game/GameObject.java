package game;

import java.awt.*;

/**
 * @Program: PlaneGame
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-02-14 12:44
 * @Describe：
 **/
public class GameObject {
    Image image;
    double x;
    double y;
    int speed;
    int width;
    int height;
    public void drawSelf(Graphics graphics){
        graphics.drawImage(image,(int)x,(int)y,null);
    }

    public GameObject(Image image, double x, double y, int speed, int width, int height) {
        super();
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public GameObject(Image image, double x, double y) {
        super();
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public GameObject() {
    }

    /**
     * 返回物体所在的矩形，便于后续的碰撞检测
     * @return
     */
    public Rectangle getRect(){
        return new Rectangle((int)x,(int)y,width,height);
    }
}
