package com.ht.meditor.window;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class DesignPanel extends JPanel {

    private  DesignMapPanel designMapPanel ;

    private DesignMaterialGroupPanel materialGroupPanel;

    private DesignToolButtonPanel buttonPanel;

    public void init() throws IOException {
        designMapPanel= new DesignMapPanel();
        materialGroupPanel= new DesignMaterialGroupPanel();
        buttonPanel= new DesignToolButtonPanel(designMapPanel);
        this.setLayout(new BorderLayout());
        this.add(materialGroupPanel,BorderLayout.WEST);
        this.add(designMapPanel,BorderLayout.CENTER);
        this.add(buttonPanel,BorderLayout.NORTH);
    }
}
