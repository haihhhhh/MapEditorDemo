package com.ht.meditor.window;


import com.ht.meditor.mode.MaterialSelect;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;

import com.ht.meditor.mode.MaterialType;

public class DesignSpriteGroupPanel extends JPanel {

     public DesignSpriteGroupPanel() throws IOException {

          JPanel jPanel = new JPanel();
          jPanel.setPreferredSize(new Dimension(240, 1100));
          JScrollPane jScrollPane= new JScrollPane(jPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
          jScrollPane.setPreferredSize(new Dimension(240, 1100));

          this.add(jScrollPane);
          this.setLayout(new GridLayout(1,1));
          InputStream in= this.getClass().getResourceAsStream("/image/1.png");
          ImageIcon imageIcon1= new ImageIcon(ImageIO.read(in));
          imageIcon1.setImage(imageIcon1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
          JLabel label1 = new JLabel(imageIcon1);
          Border blackline = BorderFactory.createLineBorder(Color.BLACK);
          label1.setBorder(blackline);
          jPanel.add(label1);
          label1.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                    MaterialSelect.selectMaterialType(MaterialType.stone);
               }
          });

          ImageIcon imageIcon2= new ImageIcon(ImageIO.read(this.getClass().getResourceAsStream("/image/2.png")));
          imageIcon2.setImage(imageIcon2.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
          JLabel label2 = new JLabel(imageIcon2);
          label2.setBorder(blackline);
          jPanel.add(label2);
          label2.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                    MaterialSelect.selectMaterialType(MaterialType.grass);
               }
          });

     }
}
