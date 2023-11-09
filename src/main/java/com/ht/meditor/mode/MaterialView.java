package com.ht.meditor.mode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;


public class HeroView extends JLabel{

    private static Image s1Img;
    private static Image s2Img;

    private Material material;

    public HeroView(Material material) {
        this.material = material;
        initImages();
    }

    private void initImages() {
        try {
            if (Objects.isNull(s1Img) || Objects.isNull(s2Img) ) {
                s1Img = ImageIO.read(this.getClass().getResourceAsStream("/images/sprites/1.png"));
                s2Img = ImageIO.read(this.getClass().getResourceAsStream("/images/sprites/2.png"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Material getHeroSprite() {
        return material;
    }


    public Image getImage() {
        if (material.getMaterialType() == MaterialType.HERO_TYPE_1) {
            return s1Img;
        }
        if (material.getMaterialType() == MaterialType.HERO_TYPE_2) {
            return s2Img;
        }
        return null;
    }
}
