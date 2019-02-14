package game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * @Program: PlaneGame
 * @Author: 麦奇
 * @Email： 1625017540@qq.com
 * @Create: 2019-02-14 12:38
 * @Describe：
 **/
public class GameUtil {
    /**
     * 工具类最好私有化构造器
     */
    private GameUtil() {
    }

    public static Image getImage(String path){
        BufferedImage bufferedImage=null;
        try{
            URL url=GameUtil.class.getClassLoader().getResource(path);
            bufferedImage= ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }
}
