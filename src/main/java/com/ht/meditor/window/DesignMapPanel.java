package com.ht.meditor.window;


import com.ht.meditor.config.SysConfig;
import com.ht.meditor.listener.MouseListener;
import com.ht.meditor.mode.souce.ImageSouce;
import com.ht.meditor.mode.MaterialSelect;
import com.ht.meditor.mode.Material;
import com.ht.meditor.view.MaterialView;
import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DesignMapPanel extends JPanel {


    private int columns = 20;
    private int rows = 20;
    private int windowWidth = 0;
    private int windowHeight = 0;
    private List<MaterialView> materialViews = new ArrayList<>();
    private JLabel bgLabel;

    private JLayeredPane jLayeredPane;

    public DesignMapPanel() throws IOException {
        //获取总窗体宽高
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle rect = ge.getMaximumWindowBounds();
        int w = rect.width + 1500;
        int h = rect.height + 1500;
        this.setLayout(null);


        jLayeredPane = new DesianMapLayeredPane();
        jLayeredPane.setBounds(0, 0, w, h);
        jLayeredPane.setLayout(null);

        jLayeredPane.setPreferredSize(new Dimension(w, h));
        JScrollPane jScrollPane = new JScrollPane(jLayeredPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setPreferredSize(new Dimension(w, h));
        // this.add(jLayeredPane);
        //设置起始位置
//        JScrollBar hBar = jScrollPane.getHorizontalScrollBar();
//        hBar.setValue(jScrollPane.getViewport().getMaximumSize().width / 2);
//        JScrollBar vBar = jScrollPane.getVerticalScrollBar();
//        vBar.setValue(jScrollPane.getViewport().getMaximumSize().height / 2 / 2);

        this.add(jScrollPane);
        this.setLayout(new GridLayout(1, 1));

        setBgImg();

        //设置鼠标点击事件
        jLayeredPane.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//               System.out.println("jLayeredPane click");
//               System.out.println(e.getY());
                addMaterial(e.getX(), e.getY());
            }
        });

        //计算行列数
        jLayeredPane.addComponentListener(new ComponentAdapter() {
                                              @Override
                                              public void componentMoved(ComponentEvent e) {
                                                  super.componentMoved(e);
                                                  DesignMapPanel.super.repaint();
//
                                              }
                                          }
        );
        columns = windowWidth / SysConfig.CPIX;
        rows = windowHeight / SysConfig.HPIX;

    }

    private void setBgImg() {
        try {
            //设置初始化时的背景图片大小
            windowWidth = jLayeredPane.getBounds().width;
            windowHeight = jLayeredPane.getBounds().height;

            bgLabel = new JLabel(new ImageIcon(ImageSouce.getBg().getScaledInstance(windowWidth, windowHeight, Image.SCALE_DEFAULT)));
            bgLabel.setBounds(0, 0, windowWidth, windowHeight);
            this.jLayeredPane.add(bgLabel, JLayeredPane.DEFAULT_LAYER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addMaterial(int x, int y) {
        System.out.println("x="+x);
        //TODO 获取拖动后的绝对位置
        int realX = x;
        int realY = y;

        int col = realX / SysConfig.CPIX;
        int row = realY / SysConfig.HPIX;

        Material material = new Material(col, row, MaterialSelect.currentMaterialType());
        MaterialView materialView = new MaterialView(material);
        Border blackline = BorderFactory.createRaisedBevelBorder();
        materialView.setBorder(blackline);

        materialView.setIcon(new ImageIcon(materialView.getImage().getScaledInstance(SysConfig.CPIX, SysConfig.HPIX, Image.SCALE_DEFAULT)));
        materialView.setBounds(col * SysConfig.CPIX, row * SysConfig.HPIX, SysConfig.CPIX, SysConfig.HPIX);
        materialViews.add(materialView);

        //将选择的图像放到找到的中心点位置
        jLayeredPane.add(materialView, JLayeredPane.DRAG_LAYER);
        System.out.println("c:" + col + ",r:" + row);
        this.updateUI();
//

    }

    public void repaint0() {

    }

    private int lineHOffset;
    private int lineCOffset;

//    @SneakyThrows
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        Graphics2D graphics2D = (Graphics2D) g;
//        graphics2D.setStroke(new BasicStroke(2.0f));
//
//        graphics2D.setColor(Color.black);
//
//        //获取当前窗口宽高大小
//        windowWidth = this.getBounds().width;
//        windowHeight = this.getBounds().height;
//
//        //绘制列线条
//        for (int i = 0; i < columns; i++) {
//            graphics2D.drawLine(i * SysConfig.CPIX, 0, i *  SysConfig.CPIX, windowHeight);
//        }
//
//        //绘制行线条
//        for (int i = 0; i < rows; i++) {
//            graphics2D.drawLine(0, i * SysConfig.HPIX, windowWidth, i * SysConfig.HPIX);
//        }
//
//
//    }

    public List<Material> getMaterials() {
        return materialViews.stream().map(materialView -> materialView.getMaterial()).collect(Collectors.toList());
    }

    public void setMaterials(List<Material> materials) {
        if (materials.size() > 0) {
            materialViews.clear();
            jLayeredPane.removeAll();
        }
        setBgImg();
        for (int i = 0; i < materials.size(); i++) {
            MaterialView materialView = new MaterialView(materials.get(i));
            Border blackline = BorderFactory.createRaisedBevelBorder();
            materialView.setBorder(blackline);
            materialView.setIcon(new ImageIcon(materialView.getImage().getScaledInstance(SysConfig.CPIX, SysConfig.HPIX, Image.SCALE_DEFAULT)));
            materialView.setBounds(materials.get(i).getCol() * SysConfig.CPIX, materials.get(i).getRow() * SysConfig.HPIX, SysConfig.CPIX, SysConfig.HPIX);
            materialViews.add(materialView);
            jLayeredPane.add(materialView, JLayeredPane.DRAG_LAYER);
        }
        if (materialViews.size() > 0) {
            this.repaint();
        }
    }
}
