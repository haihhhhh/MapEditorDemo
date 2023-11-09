package com.ht.meditor.mode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;


public class MaterialView extends JLabel{

    private static Image s1Img;
    private static Image s2Img;

    static {
        try {
            if (Objects.isNull(s1Img) || Objects.isNull(s2Img) ) {
                s1Img = ImageIO.read(MaterialView.class.getResourceAsStream("/image/1.png"));
                s2Img = ImageIO.read(MaterialView.class.getResourceAsStream("/image/2.png"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Material material;

    public MaterialView(Material material) {
        this.material = material;

    }


    public Material getMaterial() {
        return material;
    }

    public Image getImage() {
        if (material.getMaterialType() == MaterialType.stone) {
            return s1Img;
        }
        if (material.getMaterialType() == MaterialType.grass) {
            return s2Img;
        }
        return null;
    }
}
