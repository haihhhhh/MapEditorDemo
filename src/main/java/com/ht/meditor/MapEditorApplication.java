package com.ht.meditor;

import com.ht.meditor.config.SysConfig;
import com.ht.meditor.mode.souce.ImageSouce;
import com.ht.meditor.window.MainWindow;

import java.io.IOException;

/**
 * @author Haitian
 * @create 2023/11/10
 */
public class MapEditorApplication {

    public static void main(String[] args) throws IOException {
        //加载资源
        ImageSouce.initImageSouce();
        SysConfig.initConfig();
        //开启窗口
        MainWindow root = new MainWindow();
        root.init();
    }
}
