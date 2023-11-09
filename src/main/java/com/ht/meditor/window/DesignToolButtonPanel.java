package com.ht.meditor.window;


import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import com.ht.meditor.mode.MapData;

import javax.swing.*;
import java.io.File;
import java.util.stream.IntStream;

public class DesignButtonPanel extends JPanel {

    private JButton saveButton = new JButton("save zhe map");

    private  DesignMapPanel designMapPanel;

    public DesignButtonPanel(){
        saveButton.setSize(200,100);
        this.add(saveButton);
        this.saveButton.addActionListener(e -> {

            //选择哪个关卡
           // Integer selectLevel = Integer.parseInt(this.levels.getSelectedItem().toString());

            //获取地图数据
//            MapData heroMapData = MapData.builder().heroSprites(designMapPanel.heroSprites())
//                    .level(selectLevel).build();
//            String mapJson = JSONUtil.toJsonStr(heroMapData);
//
//            //获取当前项目目录
//            String usrDir = System.getProperty("user.dir");
//
//            //按照关卡将地图数据保存
//            File mapFile = new File(usrDir+File.separator+"map"+File.separator+selectLevel+".json");
//            FileUtil.writeBytes(mapJson.getBytes(),mapFile);
        });
    }
}
