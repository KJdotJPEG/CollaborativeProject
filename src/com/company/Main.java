package com.company;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends Canvas{

    JPanel panel = new JPanel();

    private static final long serialVersionUID = -240840600533728354L;
    private JPanel gui;

    public void Window(int width, int height, String title, Game game){
        game.start();

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
