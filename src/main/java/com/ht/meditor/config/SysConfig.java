package com.ht.meditor.config;

import java.io.File;

/**
 * @author Haitian
 * @create 2023/11/10
 */
public class SysConfig {
    //外部资源目录
    public static String extendPath=System.getProperty("user.dir")+ File.separator+"extendSouce";
    //地图目录
    public static String mapsSoucePaht=System.getProperty("user.dir")+ File.separator+"maps";
    //
    public static int CPIX = 50;
    public static int HPIX = 50;

    public static void initConfig(){
        //TODO
    }
}
