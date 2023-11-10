package com.ht.meditor.window;


import com.ht.meditor.mode.souce.ImageSouce;
import com.ht.meditor.mode.MaterialSelect;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import com.ht.meditor.mode.MaterialType;

public class DesignMaterialGroupPanel extends JPanel {

     public DesignMaterialGroupPanel() throws IOException {

          JPanel jPanel = new JPanel();
          jPanel.setPreferredSize(new Dimension(240, 1100));
          JScrollPane jScrollPane= new JScrollPane(jPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
          jScrollPane.setPreferredSize(new Dimension(240, 1100));

          this.add(jScrollPane);
          this.setLayout(new GridLayout(1,1));

          ImageIcon imageIconStone= new ImageIcon(ImageSouce.getImageSouceMap().get("stone"));
          imageIconStone.setImage(imageIconStone.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));

          Border blackline = BorderFactory.createLineBorder(Color.BLACK);
          JLabel labelStone = new JLabel(imageIconStone);
          labelStone.setBorder(blackline);
          jPanel.add(labelStone);
          labelStone.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                    MaterialSelect.selectMaterialType(MaterialType.stone);
                    labelStone.setOpaque(true);
                    labelStone.setBackground(Color.gray);
                    labelStone.repaint();
                    jPanel.updateUI();
               }
          });


          ImageIcon imageIconGrass= new ImageIcon(ImageSouce.getImageSouceMap().get("grass"));
          imageIconGrass.setImage(imageIconGrass.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
          JLabel labelGrass = new JLabel(imageIconGrass);
          labelGrass.setBorder(blackline);
          jPanel.add(labelGrass);
          labelGrass.setBackground(Color.red);
          labelGrass.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                    MaterialSelect.selectMaterialType(MaterialType.grass);
               }
          });


     }
}
