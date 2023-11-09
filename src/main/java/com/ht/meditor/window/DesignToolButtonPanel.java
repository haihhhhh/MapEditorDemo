package com.ht.meditor.window;


import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import com.google.gson.GsonBuilder;
import com.ht.meditor.mode.MapData;
import com.ht.meditor.mode.Material;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.List;

public class DesignToolButtonPanel extends JPanel {

    private JButton saveButton = new JButton("保存地图");
    private JButton loadButton = new JButton("读取地图");

    private  DesignMapPanel designMapPanel;

    public DesignToolButtonPanel(DesignMapPanel designMapPanel){
        this.designMapPanel = designMapPanel;
        this.add(loadButton);
        this.loadButton.addActionListener(e -> {
            // 创建文件选择器
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("选择文件");
            chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            chooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    if (f.getName().endsWith(".json")) {
                        return true;
                    }
                    return false;

                }

                @Override
                public String getDescription() {
                    return ".json";
                }
            });
            // 显示文件选择器对话框
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                // 获取用户选择的文件路径
                String filePath = chooser.getSelectedFile().getPath();
                System.out.println("用户选择的文件路径：" + filePath);
                File file= new File(filePath);
                if(FileUtil.exist(file)){
                    String jsonStr=FileUtil.readUtf8String(file);
                    if(jsonStr!=null&&!"".equals(jsonStr)){
                        try{
                            MapData data= new GsonBuilder().create().fromJson(jsonStr, MapData.class);
//                            for(int i=0;i<data.getMaterials().size();i++){
//                                System.out.println( data.getMaterials().get(i));
//                            }
                            designMapPanel.setMaterials(data.getMaterials());
                        }catch(Exception ex){
                            ex.printStackTrace();
                        }

                    }
                }
            }
        });



        saveButton.setSize(200,100);
        this.add(saveButton);
        this.saveButton.addActionListener(e -> {
            //获取当前项目目录
            String usrDir = System.getProperty("user.dir");

            //按照关卡将地图数据保存
            File mapFile = new File(usrDir+File.separator+"map"+".json");
            //获取地图数据
            MapData mapData = MapData.builder().materials(designMapPanel.getMaterials())
                    .build();
            String mapJson =  new GsonBuilder().create().toJson(mapData);


            FileUtil.writeBytes(mapJson.getBytes(),mapFile);
        });



    }
}
