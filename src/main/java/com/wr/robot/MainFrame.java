package com.wr.robot;
import javax.swing.*;
import java.awt.*;

/**
 * Created by wr on 2017/1/11.
 */
public class MainFrame extends JFrame{
   MainPanel mainPanel;
    /**
     *
     *继承自JFrame重写主方法
     * @throws HeadlessException
     */
    public MainFrame() throws HeadlessException {
        super();
        init();

    }

    /**
     *
     * init()界面初始化
     */
    public void init(){
        mainPanel = new MainPanel(500,600);
        setSize(750,600);
        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MainFrame();
    }

}

