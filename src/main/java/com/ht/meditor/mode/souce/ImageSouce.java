package com.ht.meditor.mode.souce;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Haitian
 * @create 2023/11/10
 */
public class ImageSouce {
    private static Map<String, Image> imageSouceMap = new HashMap<>();

    public static Map<String, Image> getImageSouceMap() {
        return imageSouceMap;
    }

    static {
        try {
            Image bgImg = ImageIO.read(ImageSouce.class.getResourceAsStream("/image/bg.jpeg"));
            Image stone = ImageIO.read(ImageSouce.class.getResourceAsStream("/image/stone.png"));
            Image grass = ImageIO.read(ImageSouce.class.getResourceAsStream("/image/grass.png"));
            imageSouceMap.put("bg", bgImg);
            imageSouceMap.put("stone", stone);
            imageSouceMap.put("grass", grass);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Image getBg(){
        return imageSouceMap.get("bg");
    }

    public static void initImageSouce(){
       System.out.println("initSouce");
    }
}
