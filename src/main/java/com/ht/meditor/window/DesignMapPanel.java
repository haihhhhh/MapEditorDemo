package com.ht.meditor.window;


import com.ht.meditor.mode.MaterialSelect;
import com.ht.meditor.mode.Material;
import com.ht.meditor.mode.MaterialView;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DesignMapPanel extends JPanel {

    private int cpix = 50;
    private int hpix = 50;
    private int columns = 20;
    private int rows = 20;
    private int windowWidth = 0;
    private int windowHeight = 0;
    private List<MaterialView> materialViews = new ArrayList<>();
    private static Image bgImg;
    private JLabel bgLabel ;
    

    private JLayeredPane jLayeredPane;

    public DesignMapPanel() throws IOException {

        jLayeredPane = new JLayeredPane();
        //获取总窗体宽高
        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle rect=ge.getMaximumWindowBounds();
        int w=rect.width -230;
        int h=rect.height -104 ;
        this.setLayout(null);

        //设置滚动条
        jLayeredPane = new JLayeredPane();
        jLayeredPane.setBounds(0,0,w,h);
        jLayeredPane.setLayout(null);
        this.add(jLayeredPane);

        setBgImg();

        //设置鼠标点击事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX());
                System.out.println(e.getY());
                addMaterial(e.getX(), e.getY());
            }
        });
        //计算行列数

        columns = windowWidth / columns ;
        rows = windowHeight / hpix ;

    }
    private void setBgImg(){
        try {
            //设置初始化时的背景图片大小
            windowWidth = jLayeredPane.getBounds().width;
            windowHeight = jLayeredPane.getBounds().height;
            bgImg = ImageIO.read(this.getClass().getResourceAsStream("/image/bg.jpeg"));
            bgLabel = new JLabel(new ImageIcon(bgImg.getScaledInstance(windowWidth, windowHeight, Image.SCALE_DEFAULT)));
            bgLabel.setBounds(0, 0, windowWidth, windowHeight);
            this.jLayeredPane.add(bgLabel, JLayeredPane.DEFAULT_LAYER);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void addMaterial(int x, int y) {
        //TODO 获取拖动后的绝对位置
        int realX=x;
        int realY=y;

        int col=realX/cpix;
        int row=realY/hpix;

        Material material = new Material(col, row, MaterialSelect.currentMaterialType());
        MaterialView materialView = new MaterialView(material);
        Border blackline = BorderFactory.createRaisedBevelBorder();
        materialView.setBorder(blackline);
        materialView.setIcon(new ImageIcon(materialView.getImage().getScaledInstance(cpix ,hpix,Image.SCALE_DEFAULT)));
        materialView.setBounds(col * cpix , row * hpix, cpix, hpix );
        materialViews.add(materialView);

        //将选择的图像放到找到的中心点位置
        jLayeredPane.add(materialView,JLayeredPane.DRAG_LAYER);
        System.out.println("c:" + col + ",r:" + row);
        this.updateUI();
//

    }

    @SneakyThrows
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(2.0f));

        graphics2D.setColor(Color.black);

        //获取当前窗口宽高大小
        windowWidth = this.getBounds().width;
        windowHeight = this.getBounds().height;

//        //计算宽高间距
//        cpix = windowWidth / columns - 1;
//        hpix = windowHeight / rows - 1;

        //绘制列线条
        for (int i = 0; i < columns; i++) {
            graphics2D.drawLine(i * cpix, 0, i * cpix, windowHeight);
        }

        //绘制行线条
        for (int i = 0; i < rows; i++) {
            graphics2D.drawLine(0, i * hpix, windowWidth, i * hpix);
        }


    }


    public List<Material> getMaterials(){
        return materialViews.stream().map(materialView -> materialView.getMaterial()).collect(Collectors.toList());
    }

    public void setMaterials(List<Material> materials){
        if(materials.size()>0){
            materialViews.clear();
            jLayeredPane.removeAll();
        }
        setBgImg();
        for(int i=0;i<materials.size();i++){
            MaterialView materialView=new MaterialView(materials.get(i));
            Border blackline = BorderFactory.createRaisedBevelBorder();
            materialView.setBorder(blackline);
            materialView.setIcon(new ImageIcon(materialView.getImage().getScaledInstance(cpix ,hpix,Image.SCALE_DEFAULT)));
            materialView.setBounds(materials.get(i).getCol() * cpix , materials.get(i).getRow() * hpix, cpix, hpix );
            materialViews.add(materialView);
            jLayeredPane.add(materialView,JLayeredPane.DRAG_LAYER);
        }
        if(materialViews.size()>0){
            this.repaint();
        }
    }
}
