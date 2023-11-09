package com.ht.meditor;

import com.ht.meditor.window.MainWindow;

import java.io.IOException;

/**
 * @author ht
 */
public class MapEditorApplication {

    public static void main(String[] args) throws IOException {
        MainWindow root=  new MainWindow();
        root.init();
    }
}
