package com.ht.meditor.window;

import com.ht.meditor.config.SysConfig;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;

/**
 * @author Haitian
 * @create 2023/11/10
 */
public class DesianMapLayeredPane  extends JLayeredPane {
    private  int columns;
    private  int rows;
    private  int windowWidth;
    private  int windowHeight;
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

        //绘制列线条
        for (int i = 0; i < columns; i++) {
            graphics2D.drawLine(i * SysConfig.CPIX, 0, i *  SysConfig.CPIX, windowHeight);
        }

        //绘制行线条
        for (int i = 0; i < rows; i++) {
            graphics2D.drawLine(0, i *  SysConfig.HPIX, windowWidth, i * SysConfig.HPIX);
        }


    }
}
