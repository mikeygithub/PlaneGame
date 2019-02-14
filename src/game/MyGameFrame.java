package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 * @Program: PlaneGame
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-02-14 12:33
 * @Describe：
 **/
public class MyGameFrame extends Frame {

    Image planeImg=GameUtil.getImage("images/plane.png");

    Image bg=GameUtil.getImage("images/bg.jpg");

    Plane plane=new Plane(planeImg,250,250);

    Shell[] shells=new Shell[50];

    Explode explode;

    Date startTime=new Date();
    Date endTime;
    int period;

//    @Override
//    public void print(Graphics g) {
//        Color c=g.getColor();
//        g.drawImage(bg,0,0,null);
//        plane.drawSelf(g);
//
//        for (int i=0;i<shells.length;i++){
//            shells[i].draw(g);
//            boolean  peng = shells[i].getRect().intersects(plane.getRect());
//            if (peng){
//                plane.live=false;
//                if (explode==null){
//                    explode=new Explode(plane.x,plane.y);
//                    endTime=new Date();
//                    period=(int)((endTime.getTime()-startTime.getTime())/1000);
//                }
//                explode.draw(g);
//            }
//            if (!plane.live){
//                g.setColor(Color.red);
//                Font font = new Font("宋体", Font.BOLD, 50);
//                g.setFont(font);
//                g.drawString("时间"+period+"秒",(int)plane.x,(int)plane.y);
//            }
//        }
//        g.setColor(c);
//
//    }
    @Override
    public void paint(Graphics g) {		//自动被调用。  g相当于一只画笔
        Color   c =  g.getColor();
        g.drawImage(bg, 0, 0, null);

        plane.drawSelf(g);  //画飞机

        //画出所有的炮弹
        for(int i=0;i<shells.length;i++){
            shells[i].draw(g);

            //飞机和炮弹的碰撞检测！！！
            boolean  peng = shells[i].getRect().intersects(plane.getRect());
            if(peng){
                plane.live = false;
                if(explode ==null){
                    explode  = new Explode(plane.x, plane.y);

                    endTime = new Date();
                    period = (int)((endTime.getTime()-startTime.getTime())/1000);
                }
                explode.draw(g);
            }

            //计时功能，给出提示
            if(!plane.live){
                g.setColor(Color.red);
                Font   f  =  new Font("宋体", Font.BOLD, 50);
                g.setFont(f);
                g.drawString("时间："+period+"秒", (int)plane.x, (int)plane.y);
            }

        }

        g.setColor(c);
    }
    class PaintThread extends Thread{
        @Override
        public void run() {

            while (true){
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class KeyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.minusDirection(e);

                   }
    }

    public void launchFrame(){
        this.setTitle("飞机大战");
        this.setVisible(true);
        this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        this.setLocation(300,300);



        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        new PaintThread().start();
        addKeyListener(new KeyMonitor());

        for (int i=0;i<shells.length;i++){
            shells[i]=new Shell();
        }
    }

    public static void main(String[] args){

        MyGameFrame myGameFrame = new MyGameFrame();
        myGameFrame.launchFrame();

    }

    private Image offScreenImage=null;

    public void update(Graphics graphics){
        if (offScreenImage==null)offScreenImage=this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
            Graphics graphics1 = offScreenImage.getGraphics();
            paint(graphics1);
            graphics.drawImage(offScreenImage,0,0,null);
    }
}
