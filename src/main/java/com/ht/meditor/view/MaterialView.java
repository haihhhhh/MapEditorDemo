package com.ht.meditor.view;

import com.ht.meditor.mode.souce.ImageSouce;
import com.ht.meditor.mode.Material;

import javax.swing.*;
import java.awt.*;


public class MaterialView extends JLabel {
    private Material material;

    public MaterialView(Material material) {
        this.material = material;

    }
    public Material getMaterial() {
        return material;
    }

    public Image getImage() {
        if (ImageSouce.getImageSouceMap().containsKey(material.getMaterialType().name())) {
            return ImageSouce.getImageSouceMap().get(material.getMaterialType().name());
        }
        ;
        return null;
    }
}
